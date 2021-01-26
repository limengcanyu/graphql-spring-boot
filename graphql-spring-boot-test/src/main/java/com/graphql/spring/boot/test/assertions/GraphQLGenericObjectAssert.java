package com.graphql.spring.boot.test.assertions;

import com.graphql.spring.boot.test.GraphQLResponse;
import lombok.EqualsAndHashCode;
import org.assertj.core.api.AbstractObjectAssert;

@EqualsAndHashCode(callSuper = true)
public class GraphQLGenericObjectAssert<T>
    extends AbstractObjectAssert<GraphQLGenericObjectAssert<T>, T>
    implements GraphQLResponseAssertion {

  private final GraphQLResponse graphQLResponse;

  public GraphQLGenericObjectAssert(final GraphQLResponse graphQLResponse, final T actual) {
    super(actual, GraphQLGenericObjectAssert.class);
    this.graphQLResponse = graphQLResponse;
  }

  @Override
  public GraphQLResponse and() {
    return graphQLResponse;
  }
}
