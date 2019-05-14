/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.code.impl.java;

import java.io.File;

import net.sf.mmm.code.api.expression.CodeExpression;
import net.sf.mmm.code.api.language.CodeLanguage;
import net.sf.mmm.code.base.loader.BaseLoader;
import net.sf.mmm.code.base.source.BaseSourceImpl;
import net.sf.mmm.code.base.source.BaseSourceProvider;
import net.sf.mmm.code.base.type.BaseType;
import net.sf.mmm.code.base.type.BaseTypeWildcard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of {@link JavaContext} that inherits from a {@link #getParent() parent} context.
 *
 * @author Joerg Hohwiller (hohwille at users.sourceforge.net)
 * @since 1.0.0
 */
public class JavaExtendedContext extends JavaContext {

    private final JavaContext parent;

    private final JavaClassLoader loader;

    private static final Logger LOG = LoggerFactory.getLogger(JavaExtendedContext.class);

    /**
     * The constructor.
     *
     * @param source
     *            the {@link #getSource() source}.
     * @param sourceProvider
     *            the {@link BaseSourceProvider}.
     * @param mvnClassLoader
     */
    public JavaExtendedContext(BaseSourceImpl source, BaseSourceProvider sourceProvider, ClassLoader mvnClassLoader) {

        this(JavaRootContext.get(), source, sourceProvider, mvnClassLoader);
    }

    /**
     * The constructor.
     *
     * @param parent
     *            the {@link #getParent() parent context}.
     * @param source
     *            the {@link #getSource() source}.
     * @param sourceProvider
     *            the {@link BaseSourceProvider}.
     * @param mvnClassLoader
     */
    public JavaExtendedContext(JavaContext parent, BaseSourceImpl source, BaseSourceProvider sourceProvider,
        ClassLoader mvnClassLoader) {

        super(source, sourceProvider);

        this.parent = parent;

        if (mvnClassLoader == null) {
            loader = new JavaClassLoader();
        } else {
            loader = new JavaClassLoader(mvnClassLoader);
        }

    }

    /**
     * The constructor.
     *
     * @param parent
     *            the {@link #getParent() parent context}.
     * @param source
     *            the {@link #getSource() source}.
     * @param sourceProvider
     *            the {@link BaseSourceProvider}.
     */
    public JavaExtendedContext(JavaContext parent, BaseSourceImpl source, BaseSourceProvider sourceProvider,
        File mavenProjectLocation) {

        super(source, sourceProvider);
        this.parent = parent;
        loader = new JavaClassLoader();
    }

    @Override
    public BaseLoader getLoader() {

        return loader;
    }

    @Override
    protected BaseType getTypeFromCache(String qualifiedName) {

        BaseType type = super.getTypeFromCache(qualifiedName);
        if (type == null) {
            return parent.getTypeFromCache(qualifiedName);
        }
        return type;
    }

    @Override
    public JavaContext getParent() {

        return parent;
    }

    @Override
    public JavaRootContext getRootContext() {

        return parent.getRootContext();
    }

    @Override
    public CodeExpression createExpression(Object value, boolean primitive) {

        return parent.createExpression(value, primitive);
    }

    @Override
    public BaseTypeWildcard getUnboundedWildcard() {

        return parent.getUnboundedWildcard();
    }

    @Override
    public CodeLanguage getLanguage() {

        return parent.getLanguage();
    }

    @Override
    public BaseType getRootType() {

        return parent.getRootType();
    }

    @Override
    public BaseType getRootEnumerationType() {

        return parent.getRootEnumerationType();
    }

    @Override
    public BaseType getVoidType() {

        return parent.getVoidType();
    }

    @Override
    public BaseType getRootExceptionType() {

        return parent.getRootExceptionType();
    }

    @Override
    public BaseType getNonPrimitiveType(BaseType javaType) {

        return parent.getNonPrimitiveType(javaType);
    }

    @Override
    public String getQualifiedNameForStandardType(String simpleName, boolean omitStandardPackages) {

        return parent.getQualifiedNameForStandardType(simpleName, omitStandardPackages);
    }

    @Override
    public ClassLoader getClassLoader() {

        return loader.getClassLoader();
    }

}
