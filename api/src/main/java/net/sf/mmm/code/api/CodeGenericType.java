/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.code.api;

import java.io.IOException;

import net.sf.mmm.code.api.element.CodeElementWithQualifiedName;
import net.sf.mmm.code.api.item.CodeItem;
import net.sf.mmm.code.api.type.CodeType;
import net.sf.mmm.code.api.type.CodeTypeCategory;
import net.sf.mmm.code.api.type.CodeTypeVariable;
import net.sf.mmm.code.api.type.CodeTypeVariables;

/**
 * {@link CodeItem} that represents a (potentially generic) type (similar to {@link java.lang.reflect.Type}).
 *
 * @author Joerg Hohwiller (hohwille at users.sourceforge.net)
 * @since 1.0.0
 */
public abstract interface CodeGenericType extends CodeElementWithQualifiedName {

  /**
   * @return the raw {@link CodeType}. In case of an {@link #isArray() array} the
   *         {@link Class#getComponentType() component type}. Can not be changed as it is the type itself or
   *         calculated from resolving the {@link #asTypeVariable() type variable}.
   */
  CodeType asType();

  /**
   * @return the {@link CodeTypeVariable} if this type is a type variable (e.g. "{@code T extends String}") or
   *         {@code null} for none.
   * @see #getTypeVariables()
   */
  CodeTypeVariable asTypeVariable();

  /**
   * @return the {@link CodeTypeVariables} containing the {@link CodeTypeVariable}s.
   * @see #asTypeVariable()
   */
  CodeTypeVariables getTypeVariables();

  /**
   * @return {@code true} if the usage of this type in its place is {@link CodeType#getQualifiedName() fully
   *         qualified}, {@code false} otherwise (if the {@link CodeType#getSimpleName() simple name} shall be
   *         used what is the default).
   */
  boolean isQualified();

  /**
   * @return {@code true} if this represents an array of the {@link #asType()} and potential
   *         {@link #asTypeVariable() type variable}.
   */
  boolean isArray();

  /**
   * @param type the potential sub-type.
   * @return {@code true} if this type is equal or a {@link CodeType#getSuperTypes() super type} of the given
   *         {@code type}, {@code false} otherwise.
   * @see Class#isAssignableFrom(Class)
   */
  boolean isAssignableFrom(CodeGenericType type);

  /**
   * @param context the {@link CodeGenericType type} in which to resolve this type.
   * @return the resolved type in case this is a {@link #asTypeVariable() type variable} that could be
   *         resolved or refined or this type itself otherwise.
   */
  CodeGenericType resolve(CodeGenericType context);

  /**
   * @return the {@link CodeTypeCategory} of this type.
   * @see #isClass()
   * @see #isInterface()
   * @see #isEnumeration()
   * @see #isAnnotation()
   */
  default CodeTypeCategory getCategory() {

    return asType().getCategory();
  }

  @Override
  default String getSimpleName() {

    return asType().getSimpleName();
  }

  @Override
  default CodePackage getParentPackage() {

    return asType().getParentPackage();
  }

  /**
   * @return {@code true} if this type represents an {@link CodeTypeCategory#INTERFACE interface}.
   */
  default boolean isInterface() {

    return CodeTypeCategory.INTERFACE.equals(getCategory());
  }

  /**
   * @return {@code true} if this type has the {@link #getCategory() category} {@link CodeTypeCategory#CLASS
   *         class}.
   */
  default boolean isClass() {

    return CodeTypeCategory.CLASS.equals(getCategory());
  }

  /**
   * @return {@code true} if this type has the {@link #getCategory() category}
   *         {@link CodeTypeCategory#ENUMERAION enumeration}.
   */
  default boolean isEnumeration() {

    return CodeTypeCategory.ENUMERAION.equals(getCategory());
  }

  /**
   * @return {@code true} if this type has the {@link #getCategory() category}
   *         {@link CodeTypeCategory#ANNOTATION annotation}.
   */
  default boolean isAnnotation() {

    return CodeTypeCategory.ANNOTATION.equals(getCategory());
  }

  /**
   * Internal variant of {@link #write(Appendable)} to write a reference for the usage of this type.
   *
   * @param sink the {@link Appendable} where to {@link Appendable#append(CharSequence) append} the code from
   *        this {@link CodeItem}.
   * @param declaration {@code true} if used as a declaration of {@link CodeType#getTypeVariables() type
   *        variables} (where bounds have to be included), {@code false} otherwise.
   * @throws IOException if thrown by {@link Appendable}.
   */
  void writeReference(Appendable sink, boolean declaration) throws IOException;

}