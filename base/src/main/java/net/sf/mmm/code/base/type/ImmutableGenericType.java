/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.code.base.type;

import java.io.IOException;

import net.sf.mmm.code.api.type.CodeComposedType;
import net.sf.mmm.code.api.type.CodeGenericType;
import net.sf.mmm.code.api.type.CodeReadableGenericType;
import net.sf.mmm.code.api.type.CodeReadableType;
import net.sf.mmm.code.api.type.CodeType;
import net.sf.mmm.code.api.type.CodeTypePlaceholder;
import net.sf.mmm.code.api.type.CodeTypeVariable;
import net.sf.mmm.code.api.type.CodeTypeWildcard;

/**
 * TODO: this class ...
 *
 * @author Joerg Hohwiller (hohwille at users.sourceforge.net)
 * @since 1.0.0
 */
public abstract class ImmutableGenericType<D extends CodeGenericType> extends ImmutableElement<D> implements CodeReadableGenericType {

  @Override
  public void writeReference(Appendable sink, boolean declaration, Boolean qualified) throws IOException {

    getDelegate().writeReference(sink, declaration, qualified);
  }

  @Override
  public boolean isQualified() {

    return getDelegate().isQualified();
  }

  @Override
  public String getSimpleName() {

    return getDelegate().getSimpleName();
  }

  @Override
  public String getQualifiedName() {

    return getDelegate().getQualifiedName();
  }

  @Override
  public CodeReadableType asType() {

    CodeType type = getDelegate().asType();
    if (type == null) {
      return null;
    }
    return type.getImmutable();
  }

  @Override
  public CodeReadableGenericType getComponentType() {

    CodeGenericType type = getDelegate().getComponentType();
    if (type == null) {
      return null;
    }
    return type.getImmutable();
  }

  @Override
  public CodeReadableTypePlaceholder asTypePlaceholder() {

    CodeTypePlaceholder type = getDelegate().asTypePlaceholder();
    if (type == null) {
      return null;
    }
    return type.getImmutable();
  }

  @Override
  public CodeReadableTypeVariable asTypeVariable() {

    CodeTypeVariable type = getDelegate().asTypeVariable();
    if (type == null) {
      return null;
    }
    return type.getImmutable();
  }

  @Override
  public CodeReadableTypeWildcard asTypeWildcard() {

    CodeTypeWildcard type = getDelegate().asTypeWildcard();
    if (type == null) {
      return null;
    }
    return type.getImmutable();
  }

  @Override
  public CodeReadableComposedType asComposedType() {

    CodeComposedType type = getDelegate().asComposedType();
    if (type == null) {
      return null;
    }
    return type.getImmutable();
  }

  @Override
  public CodeReadableGenericType asUnqualifiedType() {

    CodeGenericType type = getDelegate().asUnqualifiedType();
    if (type == null) {
      return null;
    }
    return type.getImmutable();
  }

  @Override
  public CodeGenericType createArray() {

    return getDelegate().createArray();
  }

  @Override
  public CodeReadableGenericTypeParameters<?> getTypeParameters() {

    return getDelegate().getTypeParameters().getImmutable();
  }

  @Override
  public boolean isArray() {

    return getDelegate().isArray();
  }

  @Override
  public boolean isAssignableFrom(CodeReadableGenericType type) {

    return getDelegate().isAssignableFrom(type);
  }

  @Override
  public CodeReadableGenericType resolve(CodeReadableGenericType context) {

    return getDelegate().resolve(context).getImmutable();
  }

}
