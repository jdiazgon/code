/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.code.api.annotation;

import net.sf.mmm.code.api.element.CodeElement;
import net.sf.mmm.code.api.node.CodeNodeItemContainerHierarchical;
import net.sf.mmm.code.api.type.CodeType;

/**
 * {@link CodeNodeItemContainerHierarchical} containing {@link CodeAnnotation}s.
 *
 * @author Joerg Hohwiller (hohwille at users.sourceforge.net)
 * @since 1.0.0
 */
public interface CodeAnnotations<A extends CodeAnnotation> extends CodeReadableAnnotations<A> {

  @Override
  CodeElement getParent();

  /**
   * @param type the {@link CodeAnnotation#getType() type} reflecting the {@link CodeType#isAnnotation()
   *        annotation}.
   * @return the new {@link CodeAnnotation} that has been created and added.
   */
  A add(CodeType type);

  /**
   * @param annotation the {@link CodeAnnotation} to add.
   */
  void add(CodeAnnotation annotation);

  /**
   * @param type the {@link CodeAnnotation#getType() type} reflecting the {@link CodeType#isAnnotation()
   *        annotation}.
   * @return the {@link CodeAnnotation} from {@link #getDeclared()} {@link CodeAnnotation#getType() with} the
   *         give {@link CodeType} or a new {@link #add(CodeType) added} one.
   */
  default A getDeclaredOrAdd(CodeType type) {

    A annotation = getDeclared(type);
    if (annotation == null) {
      annotation = add(type);
    }
    return annotation;
  }

  @Override
  CodeAnnotations<A> copy();

}
