package ${package.Controller};

import ${package.Service}.${table.serviceName};
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
<#if superControllerClass??>
import ${superControllerClassPackage};
</#if>
<#if restControllerStyle??>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Validated
@RestController
@RequestMapping("/${table.entityPath}")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

    /**
    * <p>
    * ${entity}Service
    * </p>
    */
    @Resource
    private ${entity}Service ${table.entityPath}Service;

<#--    /**-->
<#--    * <p>-->
<#--    * Get ${entity} page list by ${entity}-->
<#--    * </p>-->
<#--    * @param page page-->
<#--    * @param ${table.entityPath} ${table.entityPath}-->
<#--    * @return IPage<${entity}>-->
<#--    */-->
<#--    @GetMapping("list")-->
<#--    public Message getPage(Page<${entity}> page, @Valid ${entity} ${table.entityPath}) {-->
<#--        return new Message<>().setObj(${table.entityPath}Service.page(page, new QueryWrapper<>(${table.entityPath})));-->
<#--    }-->

<#--    /**-->
<#--    * <p>-->
<#--    * Add ${entity}-->
<#--    * </p>-->
<#--    * @param ${table.entityPath} ${table.entityPath}-->
<#--    */-->
<#--    @PostMapping("add")-->
<#--    public Message<String> add(@Valid @RequestBody <#if cfg.dtoPackage??>${entity}DTO<#else>${entity}</#if> ${table.entityPath}) {-->
<#--        ${table.entityPath}Service.saveOrUpdate(${table.entityPath});-->
<#--        return new Message<>("添加成功");-->
<#--    }-->

<#--    /**-->
<#--    * <p>-->
<#--    * Update ${entity}-->
<#--    * </p>-->
<#--    * @param ${table.entityPath} ${table.entityPath}-->
<#--    */-->
<#--    @PostMapping("update")-->
<#--    public Message<String>  update(@Valid @RequestBody <#if cfg.dtoPackage??>${entity}DTO<#else>${entity}</#if> ${table.entityPath}) {-->
<#--        ${table.entityPath}Service.saveOrUpdate(${table.entityPath});-->
<#--        return new Message<>("更新成功");-->
<#--    }-->

<#--    /**-->
<#--    * <p>-->
<#--    * Delete ${entity} by id-->
<#--    * </p>-->
<#--    * @param id id-->
<#--    */-->
<#--    @PostMapping("delete")-->
<#--    public Message<String>  delete(@Valid Long id) {-->
<#--        ${table.entityPath}Service.removeById(id);-->
<#--        return new Message<>("删除成功");-->
<#--    }-->

}
</#if>