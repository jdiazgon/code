/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.code.base.type;

import net.sf.mmm.code.api.annotation.CodeReadableAnnotations;
import net.sf.mmm.code.api.comment.CodeComment;
import net.sf.mmm.code.api.doc.CodeReadableDoc;
import net.sf.mmm.code.api.element.CodeElement;
import net.sf.mmm.code.api.element.CodeReadableElement;
import net.sf.mmm.code.api.type.CodeReadableType;

/**
 * TODO: this class ...
 *
 * @author Joerg Hohwiller (hohwille at users.sourceforge.net)
 * @since 1.0.0
 */
public abstract class ImmutableElement<D extends CodeElement> extends ImmutableNodeItem<D> implements CodeReadableElement {

  @Override
  public CodeComment getComment() {

    return getDelegate().getComment();
  }

  @Override
  public CodeReadableType getDeclaringType() {

    return getDelegate().getDeclaringType();
  }

  @Override
  public CodeReadableDoc getDoc() {

    return getDelegate().getDoc().getImmutable();
  }

  @Override
  public CodeReadableAnnotations<?> getAnnotations() {

    return getDelegate().getAnnotations().getImmutable();
  }

}
