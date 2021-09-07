/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package gql.visitors;

import antlr.GqlParser.ReturnItemContext;
import antlr.GqlParser.ReturnListContext;
import antlr.GqlParser.ReturnStatementContext;
import antlr.GqlParser.SetQuantifierContext;
import antlr.GqlParserBaseVisitor;
import gql.enums.SetQuantifier;
import gql.expressions.Expression;
import gql.returns.Asterisk;
import gql.returns.ReturnExpression;
import gql.returns.ReturnItem;
import gql.returns.ReturnStatement;

import java.util.ArrayList;


public class ReturnStatementVisitor extends GqlParserBaseVisitor {
    ExpressionVisitor expressionVisitor = new ExpressionVisitor();

    @Override
    public ReturnStatement visitReturnStatement(ReturnStatementContext ctx) {
        ArrayList<ReturnItem> returnItems = new ArrayList<>();
        returnItems.add(new Asterisk());
        if (ctx.ASTERISK() != null) return new ReturnStatement(visitSetQuantifier(ctx.setQuantifier()), returnItems);

        returnItems = visitReturnList(ctx.returnList());
        return new ReturnStatement(visitSetQuantifier(ctx.setQuantifier()), returnItems);
    }

    @Override
    public SetQuantifier visitSetQuantifier(SetQuantifierContext ctx) {
        if (ctx == null) return SetQuantifier.ALL;
        if (ctx.ALL() != null) return SetQuantifier.ALL;
        return SetQuantifier.DISTINCT;
    }

    @Override
    public ArrayList<ReturnItem> visitReturnList(ReturnListContext ctx) {
        ArrayList<ReturnItem> returnItems = new ArrayList<>();

        for (ReturnItemContext returnItemContext: ctx.returnItem()) {
            returnItems.add(visitReturnItem(returnItemContext));
        }

        return returnItems;
    }

    @Override
    public ReturnExpression visitReturnItem(ReturnItemContext ctx) {
        Expression expr = expressionVisitor.visitExpr(ctx.expr());
        if (ctx.name() != null) return new ReturnExpression(expr, ctx.name().ID().getText());

        return new ReturnExpression(expr);
    }
}
