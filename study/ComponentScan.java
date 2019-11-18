@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Repeatable(ComponentScans.class)
public @interface ComponentScan {
    /**
     * 对应的包扫描路径 可以是单个路径，也可以是扫描的路径数组
     * @return
     */
    @AliasFor("basePackages")
    String[] value() default {};
    /**
     * 和value一样是对应的包扫描路径 可以是单个路径，也可以是扫描的路径数组
     * @return
     */
    @AliasFor("value")
    String[] basePackages() default {};
    /**
     * 指定具体的扫描类
     * @return
     */
    Class<?>[] basePackageClasses() default {};
    /**
     * 对应的bean名称的生成器 默认的是BeanNameGenerator
     * @return
     */
    Class<? extends BeanNameGenerator> nameGenerator() default BeanNameGenerator.class;
    /**
     * 处理检测到的bean的scope范围
     */
    Class<? extends ScopeMetadataResolver> scopeResolver() default AnnotationScopeMetadataResolver.class;
    /**
     * 是否为检测到的组件生成代理
     */
    ScopedProxyMode scopedProxy() default ScopedProxyMode.DEFAULT;
    /**
     * 控制符合组件检测条件的类文件   默认是包扫描下的
     * @return
     */
    String resourcePattern() default ClassPathScanningCandidateComponentProvider.DEFAULT_RESOURCE_PATTERN;
    /**
     * 是否对带有@Component @Repository @Service @Controller注解的类开启检测,默认是开启的
     * @return
     */
    boolean useDefaultFilters() default true;
    /**
     * 指定某些定义Filter满足条件的组件
     * @return
     */
    Filter[] includeFilters() default {};
    /**
     * 排除某些过来器扫描到的类
     * @return
     */
    Filter[] excludeFilters() default {};
    /**
     * 扫描到的类是都开启懒加载 ，默认是不开启的
     * @return
     */
    boolean lazyInit() default false;
}