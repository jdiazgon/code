/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.code.api.node;

import net.sf.mmm.code.api.item.CodeItem;
import net.sf.mmm.code.api.item.CodeReadableItem;

/**
 * {@link CodeNode} that is also a {@link CodeItem}.
 *
 * @author Joerg Hohwiller (hohwille at users.sourceforge.net)
 * @since 1.0.0
 */
public abstract interface CodeReadableNodeItem extends CodeNode, CodeReadableItem {

  /**
   * @return a new mutable copy of the underlying {@link CodeNodeItem}. Will be a deep-copy with copies of all
   *         child {@link CodeReadableNodeItem}s.
   */
  @Override
  CodeNodeItem copy();

}
