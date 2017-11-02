/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.code.api.type;

import net.sf.mmm.code.api.element.CodeElement;
import net.sf.mmm.code.api.item.CodeItem;

/**
 * {@link CodeItem} that represents a (potentially generic) type (similar to {@link java.lang.reflect.Type}).
 *
 * @author Joerg Hohwiller (hohwille at users.sourceforge.net)
 * @since 1.0.0
 */
public abstract interface CodeGenericType extends CodeReadableGenericType, CodeElement {

  @Override
  CodeType asType();

  @Override
  CodeGenericType getComponentType();

  @Override
  CodeTypePlaceholder asTypePlaceholder();

  @Override
  CodeTypeVariable asTypeVariable();

  @Override
  CodeTypeWildcard asTypeWildcard();

  @Override
  CodeComposedType asComposedType();

  @Override
  CodeGenericType asUnqualifiedType();

  @Override
  CodeGenericTypeParameters<?> getTypeParameters();

  @Override
  CodeGenericType resolve(CodeReadableGenericType context);

  @Override
  CodeReadableGenericType getImmutable();

}
