/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.code.api.type;

import java.util.List;

import net.sf.mmm.code.api.CodeFile;
import net.sf.mmm.code.api.block.CodeBlockInitializer;
import net.sf.mmm.code.api.element.CodeElement;
import net.sf.mmm.code.api.element.CodeReadableElement;
import net.sf.mmm.code.api.element.CodeReadableElementWithTypeVariables;
import net.sf.mmm.code.api.item.CodeItemWithQualifiedNameAndParentPackage;
import net.sf.mmm.code.api.item.CodeReadableItemWithModifiers;
import net.sf.mmm.code.api.member.CodeConstructors;
import net.sf.mmm.code.api.member.CodeFields;
import net.sf.mmm.code.api.member.CodeMethods;
import net.sf.mmm.code.api.member.CodeProperties;
import net.sf.mmm.code.api.member.CodeProperty;

/**
 * {@link CodeElement} representing a type (similar to {@link Class}).
 *
 * @author Joerg Hohwiller (hohwille at users.sourceforge.net)
 * @since 1.0.0
 */
public interface CodeReadableType
    extends CodeReadableGenericType, CodeItemWithQualifiedNameAndParentPackage, CodeReadableItemWithModifiers, CodeReadableElementWithTypeVariables {

  /**
   * @return the parent element of this type. Will either be the {@link #getFile() file} or the
   *         {@link #getDeclaringType() declaring type}.
   */
  @Override
  CodeReadableElement getParent();

  /**
   * @return the {@link CodeFile} {@link CodeFile#getTypes() containing} this type.
   */
  CodeFile getFile();

  @Override
  CodeTypeCategory getCategory();

  /**
   * @return the {@link List} of {@link CodeGenericType}s inherited by this type. This model does not
   *         distinguish {@code extends} vs. {@code inherits} and potentially allows multi-inheritance of
   *         classes for languages other than Java.
   */
  CodeReadableSuperTypes<?> getSuperTypes();

  /**
   * @return the {@link CodeFields} containing the actual {@link net.sf.mmm.code.api.member.CodeField}s.
   */
  CodeReadableFields<?> getFields();

  /**
   * @return the {@link CodeMethods} containing the actual {@link net.sf.mmm.code.api.member.CodeMethod}s.
   */
  CodeReadableMethods<?> getMethods();

  /**
   * @return the {@link CodeConstructors} containing the actual
   *         {@link net.sf.mmm.code.api.member.CodeConstructor}s.
   */
  CodeReadableConstructors<?> getConstructors();

  /**
   * @return the {@link CodeProperties} containing instances of {@link CodeProperty}.
   */
  CodeReadableProperties<?> getProperties();

  /**
   * @return the {@link CodeReadableType} containing this {@link CodeReadableType} or {@code this} type itself
   *         if not a {@link #isNested() nested type}.
   */
  @Override
  CodeReadableType getDeclaringType();

  /**
   * @return {@code true} if this a nested type (sometimes called "inner class"), {@code false} otherwise
   *         (called a "top-level" type).
   * @see #getDeclaringType()
   */
  default boolean isNested() {

    return (getDeclaringType() != this);
  }

  /**
   * @return the {@link CodeNestedTypes} containing the {@link #isNested() nested} {@link CodeReadableType}s.
   *         May be {@link List#isEmpty() empty} but is never {@code null}.
   */
  CodeReadableNestedTypes<?> getNestedTypes();

  /**
   * @return the static initializer block. Will be omitted if empty. To create an empty static initializer
   *         simply add an empty statement to it. For simplicity only a single static initializer is supported
   *         by this API. Multiple static initializers will be joined (appended) automatically.
   */
  CodeBlockInitializer getStaticInitializer();

  /**
   * @return the non-static initializer block. Will be omitted if empty. To create an empty non-static
   *         initializer simply add an empty statement to it. For simplicity only a single non-static
   *         initializer is supported by this API. Multiple non-static initializers will be joined (appended)
   *         automatically.
   */
  CodeBlockInitializer getNonStaticInitializer();

  /**
   * @return {@code true} if this is a primitive type, {@code false} otherwise.
   */
  boolean isPrimitive();

  /**
   * @return the corresponding non-{@link #isPrimitive() primitive} type if this type is {@link #isPrimitive()
   *         primitive} or this type itself otherwise.
   */
  CodeReadableType getNonPrimitiveType();

  /**
   * @return {@code true} if this type represents {@link void} or {@link Void}.
   */
  boolean isVoid();

  /**
   * @return {@code true} if this type represents {@link boolean} or {@link Boolean}.
   */
  boolean isBoolean();

  /**
   * @return {@code true} if this type represents an exception (in Java any type assignable to
   *         {@link Throwable}).
   */
  boolean isException();

  @Override
  default boolean isArray() {

    return false;
  }

  @Override
  default boolean isQualified() {

    return false;
  }

  @Override
  default CodeTypeVariable asTypeVariable() {

    return null;
  }

  @Override
  default CodeReadableType asType() {

    return this;
  }

  /**
   * This method should only be called if this type actually has {@link #getTypeParameters() type variables}.
   *
   * @param parent the {@link CodeParameterizedType#getParent() parent} of the new
   *        {@link CodeParameterizedType}.
   * @return a new {@link CodeParameterizedType} with this type as {@link CodeParameterizedType#getType() raw
   *         type}.
   */
  CodeParameterizedType createParameterizedType(CodeElement parent);

  /**
   * @return the {@link CodeGenericType} representing this {@link CodeReadableType} as {@link #isQualified()
   *         fully qualified} type. If this {@link CodeReadableType} {@link #getParentPackage() is contained}
   *         in the default package this will return this type itself (e.g. for primitive types).
   */
  CodeGenericType getQualifiedType();

  @Override
  Class<?> getReflectiveObject();

  @Override
  default CodeReadableType resolve(CodeReadableGenericType context) {

    return this;
  }

  @Override
  CodeType copy();

}
