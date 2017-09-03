/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.code.impl.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.mmm.code.api.CodePackage;
import net.sf.mmm.code.impl.java.element.JavaElementWithQualifiedName;
import net.sf.mmm.code.impl.java.type.JavaType;

/**
 * Implementation of {@link CodePackage} for Java.
 *
 * @author Joerg Hohwiller (hohwille at users.sourceforge.net)
 * @since 1.0.0
 */
public class JavaPackage extends JavaElementWithQualifiedName implements CodePackage {

  /** {@link #getSimpleName() Simple name} of the default (root) package. */
  public static final String NAME_DEFAULT = "";

  /** {@link #getSimpleName() Simple name} {@value}. */
  public static final String NAME_JAVA = "java";

  /** {@link #getSimpleName() Simple name} {@value}. */
  public static final String NAME_LANG = "lang";

  /** {@link #getSimpleName() Simple name} {@value}. */
  public static final String NAME_UTIL = "util";

  private static final Logger LOG = LoggerFactory.getLogger(JavaPackage.class);

  private List<JavaPackage> childPackages;

  private List<JavaType> childTypes;

  /**
   * The constructor for a {@link JavaContext#getRootPackage() root-package}.
   *
   * @param context the {@link #getContext() context}.
   */
  public JavaPackage(JavaContext context) {

    super(context, null, "");
    this.childTypes = new ArrayList<>();
    this.childPackages = new ArrayList<>();
  }

  /**
   * The constructor.
   *
   * @param parentPackage the {@link #getParentPackage() parent package}.
   * @param simpleName the {@link #getSimpleName() simple name}.
   */
  public JavaPackage(JavaPackage parentPackage, String simpleName) {

    super(parentPackage.getContext(), parentPackage, simpleName);
  }

  /**
   * The copy-constructor.
   *
   * @param template the {@link JavaPackage} to copy.
   */
  public JavaPackage(JavaPackage template) {

    super(template);
    this.childPackages = copy(template.childPackages);
    this.childTypes = copy(template.childTypes);
  }

  @Override
  public boolean isRequireImport() {

    return !isDefault() && !isJavaLang();
  }

  /**
   * @return {@code true} if this is the default package, {@code false} otherwise.
   */
  public boolean isDefault() {

    if (getParentPackage() == null) {
      String name = getSimpleName();
      if ("".equals(name)) {
        return true;
      }
      LOG.warn("Package has no parent but non-empty name {}.", name);
    }
    return false;
  }

  /**
   * @return {@code true} if this is the "{@code java}" package, {@code false} otherwise.
   */
  public boolean isJava() {

    if (NAME_JAVA.equals(getSimpleName())) {
      JavaPackage parent = getParentPackage();
      if ((parent != null) && (parent.isDefault())) {
        return true;
      }
    }
    return false;
  }

  /**
   * @return {@code true} if this is the "{@code java.lang}" package (that requires no import), {@code false}
   *         otherwise.
   */
  public boolean isJavaLang() {

    if (NAME_LANG.equals(getSimpleName())) {
      JavaPackage parent = getParentPackage();
      if ((parent != null) && (parent.isJava())) {
        return true;
      }
    }
    return false;
  }

  @Override
  protected void doWrite(Appendable sink, String defaultIndent, String currentIndent) throws IOException {

    if (isDefault()) {
      return;
    }
    sink.append(currentIndent);
    sink.append("package ");
    sink.append(getQualifiedName());
    sink.append(';');
    writeNewline(sink);
  }

}