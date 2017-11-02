/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.code.api.item;

/**
 * {@link CodeItem} that can be mutable or immutable.
 *
 * @author Joerg Hohwiller (hohwille at users.sourceforge.net)
 * @since 1.0.0
 */
public abstract interface CodeReadableItem extends CodeItem {

  /**
   * @return the optional reflective object of this item such as {@link Class}. May be {@code null} (e.g. if
   *         this object was created from source-code only or has been created dynamically). However, if
   *         available it can be helpful for analysis especially in case of type-safe
   *         {@link java.lang.annotation.Annotation} processing. In most cases the generic type will be
   *         derived from {@link java.lang.reflect.AnnotatedElement} but in specific cases it can also be
   *         {@link java.security.ProtectionDomain} or other types that have no common parent-type. Therefore
   *         this generic type is unbounded here.
   */
  Object getReflectiveObject();

  /**
   * @return a new mutable copy of this {@link CodeReadableItem}. Will be a deep-copy with copies of all child
   *         {@link CodeReadableItem}s.
   */
  CodeMutableItem copy();

}
