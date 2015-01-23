/*
 * SonarQube JavaScript Plugin
 * Copyright (C) 2011 SonarSource and Eriks Nukis
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.javascript.model.implementations.declaration;

import com.google.common.collect.Iterators;
import com.sonar.sslr.api.AstNode;
import org.sonar.javascript.model.implementations.JavaScriptTree;
import org.sonar.javascript.model.implementations.SeparatedList;
import org.sonar.javascript.model.implementations.lexical.InternalSyntaxToken;
import org.sonar.javascript.model.interfaces.Tree;
import org.sonar.javascript.model.interfaces.declaration.ArrayBindingPatternTree;
import org.sonar.javascript.model.interfaces.declaration.BindingElementTree;
import org.sonar.javascript.parser.sslr.Optional;

import java.util.Iterator;
import java.util.List;

public class ArrayBindingPatternTreeImpl extends JavaScriptTree implements ArrayBindingPatternTree {

  private final InternalSyntaxToken openBracketToken;
  private final SeparatedList<Optional<BindingElementTree>> elements;
  private final InternalSyntaxToken closeBracketToken;

  public ArrayBindingPatternTreeImpl(
    InternalSyntaxToken openBracketToken,
    SeparatedList<Optional<BindingElementTree>> elements,
    List<AstNode> children,
    InternalSyntaxToken closeBracketToken) {

    super(Kind.ARRAY_BINDING_PATTERN);

    this.openBracketToken = openBracketToken;
    this.elements = elements;
    this.closeBracketToken = closeBracketToken;

    addChild(openBracketToken);
    for (AstNode child : children) {
      addChild(child);
    }
    addChild(closeBracketToken);
  }

  @Override
  public InternalSyntaxToken openBracketToken() {
    return openBracketToken;
  }

  @Override
  public SeparatedList<Optional<BindingElementTree>> elements() {
    return elements;
  }

  @Override
  public InternalSyntaxToken closeBracketToken() {
    return closeBracketToken;
  }

  @Override
  public Kind getKind() {
    return Kind.ARRAY_BINDING_PATTERN;
  }

  @Override
  public Iterator<Tree> childrenIterator() {
    return Iterators.emptyIterator();
  }

}