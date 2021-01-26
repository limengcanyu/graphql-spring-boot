package com.graphql.spring.boot.test.assertions;

import com.graphql.spring.boot.test.GraphQLResponse;
import lombok.EqualsAndHashCode;
import org.assertj.core.api.AbstractIntegerAssert;

@EqualsAndHashCode(callSuper = true)
public class GraphQLIntegerAssert extends AbstractIntegerAssert<GraphQLIntegerAssert>
    implements GraphQLResponseAssertion {

  private final GraphQLResponse graphQlResponse;

  public GraphQLIntegerAssert(final GraphQLResponse graphQLResponse, final Integer actual) {
    super(actual, GraphQLIntegerAssert.class);
    this.graphQlResponse = graphQLResponse;
  }

  @Override
  public GraphQLResponse and() {
    return graphQlResponse;
  }
}
