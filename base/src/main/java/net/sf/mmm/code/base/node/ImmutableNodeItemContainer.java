/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.code.base.node;

import java.util.List;
import java.util.stream.Collectors;

import net.sf.mmm.code.api.item.CodeMutableItem;
import net.sf.mmm.code.api.item.CodeReadableItem;
import net.sf.mmm.code.api.node.CodeNodeItemContainer;
import net.sf.mmm.code.api.node.CodeReadableNodeItemContainer;
import net.sf.mmm.code.api.type.CodeReadableType;
import net.sf.mmm.code.base.type.ImmutableNodeItem;

/**
 * TODO: this class ...
 *
 * @author Joerg Hohwiller (hohwille at users.sourceforge.net)
 * @since 1.0.0
 */
public abstract class ImmutableNodeItemContainer<I extends CodeReadableItem, D extends CodeNodeItemContainer<CodeMutableItem>> extends ImmutableNodeItem<D>
    implements CodeReadableNodeItemContainer<I> {

  @Override
  public List<? extends I> getDeclared() {

    return (List) getDelegate().getDeclared().stream().map(x -> x.getImmutable()).collect(Collectors.toList());
  }

  @Override
  public CodeReadableType getDeclaringType() {

    return getDelegate().getDeclaringType();
  }

}
