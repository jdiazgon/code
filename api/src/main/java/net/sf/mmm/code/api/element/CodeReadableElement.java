/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.code.api.element;

import net.sf.mmm.code.api.annotation.CodeAnnotations;
import net.sf.mmm.code.api.annotation.CodeReadableAnnotations;
import net.sf.mmm.code.api.doc.CodeDoc;
import net.sf.mmm.code.api.doc.CodeReadableDoc;
import net.sf.mmm.code.api.item.CodeItemWithComment;
import net.sf.mmm.code.api.item.CodeItemWithDeclaringType;
import net.sf.mmm.code.api.item.CodeMutableItemWithType;
import net.sf.mmm.code.api.node.CodeReadableNodeItem;

/**
 * {@link CodeMutableItemWithType} that might be {@link #getAnnotations() annotated} or {@link #getDoc()
 * documented}.
 *
 * @author Joerg Hohwiller (hohwille at users.sourceforge.net)
 * @since 1.0.0
 */
public abstract interface CodeReadableElement extends CodeReadableNodeItem, CodeItemWithComment, CodeItemWithDeclaringType {

  /**
   * @return the {@link CodeDoc documentation} of this element. May be {@link CodeDoc#isEmpty() empty} but
   *         will never be {@code null}.
   */
  CodeReadableDoc getDoc();

  /**
   * @return the {@link CodeAnnotations} with the {@link net.sf.mmm.code.api.annotation.CodeAnnotation}s of
   *         this element.
   */
  CodeReadableAnnotations<?> getAnnotations();

  @Override
  CodeElement copy();

}
