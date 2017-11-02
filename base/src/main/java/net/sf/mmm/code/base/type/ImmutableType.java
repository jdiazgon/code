/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.code.base.type;

import net.sf.mmm.code.api.CodePackage;
import net.sf.mmm.code.api.block.CodeBlockInitializer;
import net.sf.mmm.code.api.element.CodeElement;
import net.sf.mmm.code.api.element.CodeReadableElement;
import net.sf.mmm.code.api.modifier.CodeModifiers;
import net.sf.mmm.code.api.type.CodeParameterizedType;
import net.sf.mmm.code.api.type.CodeReadableGenericType;
import net.sf.mmm.code.api.type.CodeReadableType;
import net.sf.mmm.code.api.type.CodeType;
import net.sf.mmm.code.api.type.CodeTypeCategory;

/**
 * TODO: this class ...
 *
 * @author Joerg Hohwiller (hohwille at users.sourceforge.net)
 * @since 1.0.0
 */
public class ImmutableType extends ImmutableGenericType<CodeType> implements CodeReadableType {

  private final CodeType delegate;

  /**
   * The constructor.
   *
   * @param delegate
   */
  public ImmutableType(CodeType delegate) {

    super();
    this.delegate = delegate;
  }

  @Override
  protected CodeType getDelegate() {

    return this.delegate;
  }

  @Override
  public CodeModifiers getModifiers() {

    return this.delegate.getModifiers();
  }

  @Override
  public CodePackage getParentPackage() {

    return this.delegate.getParentPackage().getImmutable();
  }

  @Override
  public CodeReadableTypeVariables<?> getTypeParameters() {

    return this.delegate.getTypeParameters().getImmutable();
  }

  @Override
  public CodeReadableElement getParent() {

    return this.delegate.getParent().getImmutable();
  }

  @Override
  public CodeReadableFile getFile() {

    return this.delegate.getFile().getImmutable();
  }

  @Override
  public CodeTypeCategory getCategory() {

    return this.delegate.getCategory();
  }

  @Override
  public CodeReadableSuperTypes<?> getSuperTypes() {

    return this.delegate.getSuperTypes().getImmutable();
  }

  @Override
  public CodeReadableFields<?> getFields() {

    return this.delegate.getFields().getImmutable();
  }

  @Override
  public CodeReadableMethods<?> getMethods() {

    return this.delegate.getMethods().getImmutable();
  }

  @Override
  public CodeReadableConstructors<?> getConstructors() {

    return this.delegate.getConstructors().getImmutable();
  }

  @Override
  public CodeReadableProperties<?> getProperties() {

    return this.delegate.getProperties().getImmutable();
  }

  @Override
  public CodeReadableNestedTypes<?> getNestedTypes() {

    return this.delegate.getNestedTypes().getImmutable();
  }

  @Override
  public CodeBlockInitializer getStaticInitializer() {

    CodeBlockInitializer initializer = this.delegate.getStaticInitializer();
    if (initializer == null) {
      return null;
    }
    return initializer.getImmutable();
  }

  @Override
  public CodeBlockInitializer getNonStaticInitializer() {

    CodeBlockInitializer initializer = this.delegate.getNonStaticInitializer();
    if (initializer == null) {
      return null;
    }
    return initializer.getImmutable();
  }

  @Override
  public boolean isPrimitive() {

    return this.delegate.isPrimitive();
  }

  @Override
  public CodeReadableType getNonPrimitiveType() {

    return this.delegate.getNonPrimitiveType().getImmutable();
  }

  @Override
  public boolean isVoid() {

    return this.delegate.isVoid();
  }

  @Override
  public boolean isBoolean() {

    return this.delegate.isBoolean();
  }

  @Override
  public boolean isException() {

    return this.delegate.isException();
  }

  @Override
  public CodeParameterizedType createParameterizedType(CodeElement parent) {

    return this.delegate.createParameterizedType(parent);
  }

  @Override
  public CodeReadableGenericType getQualifiedType() {

    return this.delegate.getQualifiedType().getImmutable();
  }

  @Override
  public Class<?> getReflectiveObject() {

    return this.delegate.getReflectiveObject();
  }

  @Override
  public CodeType copy() {

    return this.delegate.copy();
  }

  @Override
  public CodeReadableType resolve(CodeReadableGenericType context) {

    return this.delegate.resolve(context).getImmutable();
  }

}
