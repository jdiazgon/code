/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.code.api.type;

import net.sf.mmm.code.api.item.CodeItemWithName;
import net.sf.mmm.code.api.node.CodeNodeItem;
import net.sf.mmm.util.exception.api.ReadOnlyException;

/**
 * {@link CodeGenericType} representing a placeholder for a {@link CodeGenericType generic} {@link CodeType
 * type}. It will either be a {@link CodeTypeVariable} or a {@link CodeTypeWildcard}.
 *
 * @see #isWildcard()
 * @see CodeTypeVariable
 * @see CodeTypeWildcard
 *
 * @author Joerg Hohwiller (hohwille at users.sourceforge.net)
 * @since 1.0.0
 */
public abstract interface CodeTypePlaceholder extends CodeGenericType, CodeReadableTypePlaceholder, CodeItemWithName {

  /** {@link #getName() Name} of a {@link #isWildcard() wildcard}. */
  String NAME_WILDCARD = "?";

  @Override
  CodeNodeItem getParent();

  /**
   * @return {@code true} if this type placeholder extends a given {@link #getBound() bound} (e.g.
   *         "{@code T extends String}"), {@code false} otherwise (if {@link #isSuper() super}).
   */
  @Override
  boolean isExtends();

  /**
   * @return {@code true} if this type placeholder represents the given {@link #getBound() bound} itself or is
   *         a super-type of it (e.g. "{@code ? super String}"), {@code false} otherwise (if
   *         {@link #isExtends() extends}). So far only {@link #isWildcard() wildcards} can return
   *         {@code true} here.
   */
  @Override
  default boolean isSuper() {

    return !isExtends();
  }

  /**
   * @return {@code true} if this is a {@link CodeTypeWildcard} (e.g. "{@code ? super String}"), {@code false}
   *         if a {@link CodeTypeVariable} (e.g. "{@code T extends Number}").
   */
  @Override
  boolean isWildcard();

  /**
   * @return the {@link CodeGenericType} representing the {@link java.lang.reflect.TypeVariable#getBounds()
   *         bound(s)} of this type placeholder. May be a {@link CodeComposedType} to specify multiple bounds.
   */
  @Override
  CodeGenericType getBound();

  /**
   * @param bound the new {@link #getBound() bound}.
   * @throws ReadOnlyException if {@link #isImmutable() immutable}.
   */
  void setBound(CodeGenericType bound);

  @Override
  default boolean isQualified() {

    return false;
  }

  @Override
  default CodeTypePlaceholder asTypePlaceholder() {

    return this;
  }

  /**
   * @deprecated a {@link CodeTypePlaceholder} can not have {@link CodeTypeVariables}. The result will always
   *             be empty and {@link #isImmutable() immutable}.
   */
  @Deprecated
  @Override
  CodeGenericTypeParameters<?> getTypeParameters();

  @Override
  CodeReadableTypePlaceholder getImmutable();

  @Override
  CodeTypePlaceholder copy();

}
