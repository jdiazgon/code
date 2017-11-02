/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.code.api.type;

import net.sf.mmm.code.api.CodeFile;
import net.sf.mmm.code.api.block.CodeBlockInitializer;
import net.sf.mmm.code.api.element.CodeElement;
import net.sf.mmm.code.api.element.CodeElementWithTypeVariables;
import net.sf.mmm.code.api.item.CodeItemWithModifiers;
import net.sf.mmm.code.api.item.CodeMutableItemWithQualifiedName;
import net.sf.mmm.code.api.member.CodeConstructors;
import net.sf.mmm.code.api.member.CodeFields;
import net.sf.mmm.code.api.member.CodeMethods;
import net.sf.mmm.code.api.member.CodeProperties;

/**
 * {@link CodeElement} representing a type (similar to {@link Class}).
 *
 * @author Joerg Hohwiller (hohwille at users.sourceforge.net)
 * @since 1.0.0
 */
public interface CodeType extends CodeReadableType, CodeGenericType, CodeItemWithModifiers, CodeMutableItemWithQualifiedName, CodeElementWithTypeVariables {

  @Override
  CodeElement getParent();

  @Override
  CodeFile getFile();

  /**
   * @param category the {@link #getCategory() category}.
   */
  void setCategory(CodeTypeCategory category);

  @Override
  CodeSuperTypes<?> getSuperTypes();

  @Override
  CodeFields<?> getFields();

  @Override
  CodeMethods<?> getMethods();

  @Override
  CodeConstructors<?> getConstructors();

  @Override
  CodeProperties<?> getProperties();

  @Override
  CodeType getDeclaringType();

  @Override
  CodeNestedTypes<?> getNestedTypes();

  @Override
  CodeBlockInitializer getStaticInitializer();

  /**
   * @param initializer the new value of {@link #getStaticInitializer()}. Has to be
   *        {@link CodeBlockInitializer#isStatic() static}.
   */
  void setStaticInitializer(CodeBlockInitializer initializer);

  @Override
  CodeBlockInitializer getNonStaticInitializer();

  /**
   * @param initializer the new value of {@link #getNonStaticInitializer()}. Shall not be
   *        {@link CodeBlockInitializer#isStatic() static}.
   */
  void setNonStaticInitializer(CodeBlockInitializer initializer);

  @Override
  CodeType getNonPrimitiveType();

  @Override
  default CodeTypeVariable asTypeVariable() {

    return null;
  }

  @Override
  default CodeType asType() {

    return this;
  }

  @Override
  CodeGenericType getQualifiedType();

  @Override
  default CodeType resolve(CodeReadableGenericType context) {

    return this;
  }

  @Override
  CodeReadableType getImmutable();

  @Override
  CodeType copy();

}
