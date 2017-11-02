/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.code.base.type;

import net.sf.mmm.code.api.CodeContext;
import net.sf.mmm.code.api.node.CodeNode;
import net.sf.mmm.code.api.node.CodeNodeItem;
import net.sf.mmm.code.api.node.CodeReadableNodeItem;
import net.sf.mmm.code.api.source.CodeSource;
import net.sf.mmm.code.api.syntax.CodeSyntax;

/**
 * TODO: this class ...
 *
 * @author Joerg Hohwiller (hohwille at users.sourceforge.net)
 * @since 1.0.0
 */
public abstract class ImmutableNodeItem<D extends CodeNodeItem> implements CodeReadableNodeItem {

  protected abstract D getDelegate();

  @Override
  public CodeNode getParent() {

    return getDelegate().getParent();
  }

  @Override
  public CodeContext getContext() {

    return getDelegate().getContext();
  }

  @Override
  public CodeSource getSource() {

    return getDelegate().getSource();
  }

  @Override
  public CodeSyntax getSyntax() {

    return getDelegate().getSyntax();
  }

  @Override
  public void write(Appendable sink, String newline, String defaultIndent, String currentIndent, CodeSyntax syntax) {

    getDelegate().write(sink, newline, defaultIndent, currentIndent, syntax);
  }

  @Override
  public String getSourceCode() {

    return getDelegate().getSourceCode();
  }

}
