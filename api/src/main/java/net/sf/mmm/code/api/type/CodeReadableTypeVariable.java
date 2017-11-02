/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.code.api.type;

import java.lang.reflect.TypeVariable;

import net.sf.mmm.code.api.node.CodeNodeItemWithDeclaringOperation;

/**
 * {@link CodeGenericType} representing a type variable. It is a variable as a placeholder for a
 * {@link CodeGenericType generic} {@link CodeType type}.
 *
 * @see java.lang.reflect.TypeVariable
 * @see CodeType#getTypeParameters()
 * @see net.sf.mmm.code.api.member.CodeOperation#getTypeParameters()
 * @see CodeGenericType#asTypeVariable()
 * @see CodeTypeVariables
 *
 * @author Joerg Hohwiller (hohwille at users.sourceforge.net)
 * @since 1.0.0
 */
public interface CodeReadableTypeVariable extends CodeReadableTypePlaceholder, CodeNodeItemWithDeclaringOperation {

  @Override
  CodeTypeVariables<?> getParent();

  @Override
  default boolean isExtends() {

    return true;
  }

  @Override
  default boolean isWildcard() {

    return false;
  }

  @Override
  default CodeReadableTypeVariable asTypeVariable() {

    return this;
  }

  @Override
  TypeVariable<?> getReflectiveObject();

  @Override
  CodeTypeVariable copy();

}
