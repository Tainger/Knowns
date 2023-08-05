package ${cfg.dtoPackage};

<#list table.importPackages as pkg>
    import ${pkg};
</#list>
<#if swagger2>
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
</#if>
<#if entityLombokModel>
import lombok.Data;
import lombok.EqualsAndHashCode;
    <#if chainModel>
import lombok.experimental.Accessors;
    </#if>
</#if>

/**
 * <p>
 * ${table.comment!}
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if entityLombokModel>
@Data
    <#if superEntityClass??>
@EqualsAndHashCode(callSuper = true)
    <#else>
@EqualsAndHashCode(callSuper = false)
    </#if>
    <#if chainModel>
@Accessors(chain = true)
    </#if>
</#if>
<#if swagger2>
@ApiModel(value="${entity}DTO对象", description="${table.comment!}")
</#if>
public class ${entity}DTO implements Serializable {
<#if entitySerialVersionUID>
    private static final long serialVersionUID = 1L;
</#if>
<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>
    <#assign hasIncludeFields = cfg.includeFields??/>
    <#assign included = hasIncludeFields && "${cfg.includeFields}"?split(',')?seq_contains("${field.propertyName}") />
    <#assign hasExcludeFields = cfg.excludeFields??/>
    <#assign excluded = hasExcludeFields && "${cfg.excludeFields}"?split(',')?seq_contains("${field.propertyName}") />
    <#if included || !hasIncludeFields && !excluded>

        <#if field.keyFlag>
            <#assign keyPropertyName="${field.propertyName}"/>
        </#if>
        <#if field.comment!?length gt 0>
            <#if swagger2>
    @ApiModelProperty(value = "${field.comment}")
            <#else>
    /**
    * ${field.comment}
    */
            </#if>
        </#if>
    private ${field.propertyType} ${field.propertyName};
    </#if>
</#list>
<#------------  END 字段循环遍历  ---------->
<#if !entityLombokModel>
    <#list table.fields as field>
        <#assign hasIncludeFields = cfg.includeFields??/>
        <#assign included = hasIncludeFields && "${cfg.includeFields}"?split(',')?seq_contains("${field.propertyName}") />
        <#assign hasExcludeFields = cfg.excludeFields??/>
        <#assign excluded = hasExcludeFields && "${cfg.excludeFields}"?split(',')?seq_contains("${field.propertyName}") />
        <#if included || !hasIncludeFields && !excluded>
            <#if field.propertyType == "boolean">
                <#assign getprefix="is"/>
            <#else>
                <#assign getprefix="get"/>
            </#if>

    public ${field.propertyType} ${getprefix}${field.capitalName}() {
        return ${field.propertyName};
    }
            <#if chainModel>

    public ${entity}DTO set${field.capitalName}(${field.propertyType} ${field.propertyName}) {
            <#else>

    public void set${field.capitalName}(${field.propertyType} ${field.propertyName}) {
            </#if>
        this.${field.propertyName} = ${field.propertyName};
            <#if chainModel>
        return this;
            </#if>
    }
        </#if>
    </#list>
</#if>

<#if entityColumnConstant>
    <#list table.fields as field>
    public static final String ${field.name?upper_case} = "${field.name}";

    </#list>
</#if>
<#if activeRecord>
    @Override
    protected Serializable pkVal() {
    <#if keyPropertyName??>
        return this.${keyPropertyName};
    <#else>
        return null;
    </#if>
    }

</#if>
<#if !entityLombokModel>
    @Override
    public String toString() {
        return "${entity}DTO{" +
    <#list table.fields as field>
        <#assign hasIncludeFields = cfg.includeFields??/>
        <#assign included = hasIncludeFields && "${cfg.includeFields}"?split(',')?seq_contains("${field.propertyName}") />
        <#assign hasExcludeFields = cfg.excludeFields??/>
        <#assign excluded = hasExcludeFields && "${cfg.excludeFields}"?split(',')?seq_contains("${field.propertyName}") />
        <#if included || !hasIncludeFields && !excluded>
            <#if field_index==0>
                "${field.propertyName}=" + ${field.propertyName} +
            <#else>
                ", ${field.propertyName}=" + ${field.propertyName} +
            </#if>
        </#if>
    </#list>
        "}";
    }
</#if>
}
