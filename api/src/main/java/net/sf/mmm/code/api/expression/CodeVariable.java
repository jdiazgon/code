/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.code.api.expression;

import net.sf.mmm.code.api.item.CodeReadableItemWithName;
import net.sf.mmm.code.api.item.CodeItemWithType;

/**
 * {@link CodeExpression} for a variable (local variable, {@link net.sf.mmm.code.api.arg.CodeParameter
 * parameter}, {@link net.sf.mmm.code.api.member.CodeField field}).
 *
 * @author Joerg Hohwiller (hohwille at users.sourceforge.net)
 * @since 1.0.0
 */
public abstract interface CodeVariable extends CodeExpression, CodeReadableItemWithName, CodeItemWithType {

}
