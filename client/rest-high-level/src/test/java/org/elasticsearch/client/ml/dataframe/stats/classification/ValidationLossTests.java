/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.elasticsearch.client.ml.dataframe.stats.classification;

import org.elasticsearch.client.ml.dataframe.stats.common.FoldValuesTests;
import org.elasticsearch.common.xcontent.XContentParser;
import org.elasticsearch.test.AbstractXContentTestCase;

import java.io.IOException;

public class ValidationLossTests extends AbstractXContentTestCase<ValidationLoss> {

    @Override
    protected boolean supportsUnknownFields() {
        return true;
    }

    @Override
    protected ValidationLoss doParseInstance(XContentParser parser) throws IOException {
        return ValidationLoss.PARSER.apply(parser, null);
    }

    @Override
    protected ValidationLoss createTestInstance() {
        return createRandom();
    }

    public static ValidationLoss createRandom() {
        return new ValidationLoss(
            randomBoolean() ? null : randomAlphaOfLength(10),
            randomBoolean() ? null : randomList(5, () -> FoldValuesTests.createRandom())
        );
    }
}
