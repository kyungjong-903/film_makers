package im.rubric.filmmakers.common;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.Querydsl;
import org.springframework.data.querydsl.SimpleEntityPathResolver;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Repository
public abstract class AbstractQuerydslRepository {

    @Autowired
    private EntityManager entityManager;
    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    protected JPAQueryFactory getJpaQueryFactory() {
        return jpaQueryFactory;
    }

    protected <T> JPAQuery<T> select(Expression<T> expression) {
        return getJpaQueryFactory().select(expression);
    }

    protected <T> JPAQuery<T> selectFrom(EntityPath<T> entityPath) {
        return getJpaQueryFactory().selectFrom(entityPath);
    }

    public Querydsl getQuerydsl(Class domainClass) {
        JpaEntityInformation entityInformation = JpaEntityInformationSupport.getEntityInformation(
                domainClass, entityManager);
        SimpleEntityPathResolver simpleEntityPathResolver = SimpleEntityPathResolver.INSTANCE;
        EntityPath path = simpleEntityPathResolver.createPath(entityInformation.getJavaType());

        return new Querydsl(entityManager,
                new PathBuilder<>(path.getType(), path.getMetadata()));
    }

    protected <T> Page<T> applyPagination(
            Pageable pageable,
            Class domainClass,
            Function<JPAQueryFactory, JPAQuery> contentQuery,
            Function<JPAQueryFactory, JPAQuery<Long>> countQuery
    ) {
        JPAQuery jpaContentQuery = contentQuery.apply(getJpaQueryFactory());
        List<T> content = getQuerydsl(domainClass).applyPagination(pageable, jpaContentQuery).fetch();
        JPAQuery<Long> jpaCountQuery = countQuery.apply(getJpaQueryFactory());

        return PageableExecutionUtils.getPage(content, pageable, jpaCountQuery::fetchFirst);
    }

}
