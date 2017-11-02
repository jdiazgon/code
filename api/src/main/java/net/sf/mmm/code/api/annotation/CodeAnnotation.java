/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.code.api.annotation;

import net.sf.mmm.code.api.item.CodeMutableItemWithComment;
import net.sf.mmm.code.api.item.CodeMutableItemWithType;

/**
 * {@link CodeMutableItemWithType} that represents an {@link java.lang.annotation.Annotation} instance.
 *
 * @author Joerg Hohwiller (hohwille at users.sourceforge.net)
 * @since 1.0.0
 */
public interface CodeAnnotation extends CodeReadableAnnotation, CodeMutableItemWithType, CodeMutableItemWithComment {

}
