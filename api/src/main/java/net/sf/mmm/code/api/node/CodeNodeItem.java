/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.code.api.node;

import net.sf.mmm.code.api.item.CodeMutableItem;

/**
 * Mutable variante of {@link CodeReadableNodeItem}.
 *
 * @author Joerg Hohwiller (hohwille at users.sourceforge.net)
 * @since 1.0.0
 */
public abstract interface CodeNodeItem extends CodeReadableNodeItem, CodeMutableItem {

  @Override
  CodeReadableNodeItem getImmutable();

}
