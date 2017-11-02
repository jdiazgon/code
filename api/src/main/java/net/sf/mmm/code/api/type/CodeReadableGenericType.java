/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.code.api.type;

import java.lang.reflect.Type;

import net.sf.mmm.code.api.element.CodeReadableElement;
import net.sf.mmm.code.api.item.CodeItem;
import net.sf.mmm.code.api.item.CodeItemWithDeclaration;
import net.sf.mmm.code.api.item.CodeItemWithQualifiedName;

/**
 * {@link CodeItem} that represents a (potentially generic) type (similar to {@link java.lang.reflect.Type}).
 *
 * @author Joerg Hohwiller (hohwille at users.sourceforge.net)
 * @since 1.0.0
 */
public abstract interface CodeReadableGenericType extends CodeReadableElement, CodeItemWithDeclaration, CodeItemWithQualifiedName {

  /**
   * @return the raw {@link CodeType}. In case of an {@link #isArray() array} the
   *         {@link net.sf.mmm.code.api.CodeContext#getRootType() root type}.
   */
  CodeReadableType asType();

  /**
   * @return the {@link CodeReadableGenericType} of the contained elements (e.g. if case of an
   *         {@link #isArray() array}) or {@code null} if no container type.
   */
  CodeReadableGenericType getComponentType();

  /**
   * @return the {@link CodeTypePlaceholder} if this type is a type placeholder or {@code null} otherwise.
   * @see #getTypeParameters()
   */
  CodeReadableTypePlaceholder asTypePlaceholder();

  /**
   * @return the {@link CodeTypeVariable} if this type is a type variable (e.g. "{@code T extends String}") or
   *         {@code null} otherwise.
   * @see #getTypeParameters()
   */
  CodeReadableTypeVariable asTypeVariable();

  /**
   * @return the {@link CodeTypeWildcard} if this type is a type wildcard (e.g. "{@code ? super String}") or
   *         {@code null} otherwise.
   * @see #getTypeParameters()
   */
  CodeTypeWildcard asTypeWildcard();

  /**
   * @return the {@link CodeComposedType} if this type is composed or {@code null} otherwise.
   */
  CodeComposedType asComposedType();

  /**
   * @return the unqualified {@link CodeReadableGenericType} corresponding to this type if
   *         {@link #isQualified() qualified} or this type itself if already unqualified.
   */
  CodeReadableGenericType asUnqualifiedType();

  /**
   * @return an {@link #isArray() array} of this type.
   */
  CodeGenericType createArray();

  /**
   * @return the {@link CodeTypeVariables} containing the {@link CodeTypeVariable}s.
   * @see #asTypeVariable()
   */
  CodeGenericTypeParameters<?> getTypeParameters();

  /**
   * @return {@code true} if this represents an array of the {@link #getComponentType()} and potential
   *         {@link #asTypeVariable() type variable}.
   */
  boolean isArray();

  /**
   * @param type the potential sub-type.
   * @return {@code true} if this type is equal to or a {@link CodeType#getSuperTypes() super type} of the
   *         given {@code type}, {@code false} otherwise.
   * @see Class#isAssignableFrom(Class)
   */
  boolean isAssignableFrom(CodeReadableGenericType type);

  /**
   * Determines if this type can be assigned to the given {@link CodeReadableGenericType}. Applies if
   * instances of this type can be casted to the given {@link CodeReadableGenericType}. This is the inverse
   * operation of {@link #isAssignableFrom(CodeReadableGenericType)} that was introduced as analogy to
   * {@link Class#isAssignableFrom(Class)}. As however many people struggle with
   * {@link #isAssignableFrom(CodeReadableGenericType)} this method is more easy and natural to use and
   * understand.
   *
   * @param type the potential super-type.
   * @return {@code true} if this type is equal to or a sub type of the given {@code type}, {@code false}
   *         otherwise.
   */
  default boolean isAssignableTo(CodeReadableGenericType type) {

    return type.isAssignableFrom(this);
  }

  /**
   * @param context the {@link CodeReadableGenericType type} in which to resolve this type.
   * @return the resolved type in case this is a {@link #asTypeVariable() type variable} that could be
   *         resolved or refined or this type itself otherwise.
   */
  CodeReadableGenericType resolve(CodeReadableGenericType context);

  /**
   * @return the {@link CodeTypeCategory} of this type. Will be {@code null} for {@link #isArray() array}.
   * @see #isClass()
   * @see #isInterface()
   * @see #isEnumeration()
   * @see #isAnnotation()
   */
  default CodeTypeCategory getCategory() {

    return asType().getCategory();
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

  @Override
  Type getReflectiveObject();

  @Override
  CodeGenericType copy();

}
