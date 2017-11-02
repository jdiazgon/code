/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.code.api.doc;

import net.sf.mmm.code.api.element.CodeElement;
import net.sf.mmm.code.api.item.CodeItem;
import net.sf.mmm.code.api.node.CodeNodeItem;

/**
 * {@link CodeItem} representing API documentation (e.g. JavaDoc or JSDoc).
 *
 * @author Joerg Hohwiller (hohwille at users.sourceforge.net)
 * @since 1.0.0
 */
public interface CodeDoc extends CodeReadableDoc, CodeNodeItem {

  @Override
  CodeElement getParent();

  @Override
  CodeDoc getImmutable();

}
