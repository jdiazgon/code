/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.code.api.item;

import net.sf.mmm.code.api.element.CodeElement;
import net.sf.mmm.code.api.modifier.CodeModifiers;

/**
 * {@link CodeElement} that has {@link #getModifiers() modifiers}.
 *
 * @author Joerg Hohwiller (hohwille at users.sourceforge.net)
 * @since 1.0.0
 */
public abstract interface CodeItemWithModifiers extends CodeMutableItem, CodeReadableItemWithModifiers {

  /**
   * @param modifiers the new {@link #getModifiers() modifiers}.
   */
  void setModifiers(CodeModifiers modifiers);

  @Override
  CodeReadableItemWithModifiers getImmutable();

  @Override
  CodeItemWithModifiers copy();

}
