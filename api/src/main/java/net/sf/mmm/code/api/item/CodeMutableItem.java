/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.code.api.item;

/**
 * {@link CodeReadableItem} that is mutable and can therefore be modified.
 *
 * @author Joerg Hohwiller (hohwille at users.sourceforge.net)
 * @since 1.0.0
 */
public abstract interface CodeMutableItem extends CodeReadableItem {

  /**
   * @return the immutable view on this item. It can not be modified.
   */
  CodeReadableItem getImmutable();

}
