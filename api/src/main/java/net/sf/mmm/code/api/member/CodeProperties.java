/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.code.api.member;

import net.sf.mmm.code.api.node.CodeNodeItemContainerHierarchicalWithName;
import net.sf.mmm.util.exception.api.ReadOnlyException;

/**
 * {@link CodeMembers} as a container for the {@link CodeProperty}s. <br>
 * <b>Attention:</b><br>
 * The {@link CodeProperty properties} are calculated on the fly and the operations may be expensive. Avoid
 * subsequent calls to the same method if possible.
 *
 * @author Joerg Hohwiller (hohwille at users.sourceforge.net)
 * @param <P> the type of the contained {@link CodeProperty properties}.
 * @since 1.0.0
 */
public interface CodeProperties<P extends CodeProperty> extends CodeMembers<P>, CodeNodeItemContainerHierarchicalWithName<P> {

  /**
   * @deprecated instances of {@link CodeProperty} are dynamically created on the fly.
   */
  @Deprecated
  @Override
  default P add(String name) {

    throw new ReadOnlyException(getDeclaringType().getSimpleName(), "properties");
  }

  @Override
  CodeProperties<P> getImmutable();

  @Override
  CodeProperties<P> copy();

}
