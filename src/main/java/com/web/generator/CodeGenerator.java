package com.web.generator;

import com.jfinal.kit.PathKit;
import io.jboot.codegen.model.JbootBaseModelGenerator;
import io.jboot.codegen.model.JbootModelGenerator;
import io.jboot.codegen.service.JbootServiceImplGenerator;
import io.jboot.codegen.service.JbootServiceInterfaceGenerator;

public class CodeGenerator {

    public static void main(String args[]){
        String modelPackage = "com.web.generator.model"; //设置model的包名
        String baseModelPackage = modelPackage + ".base";

        //生成代码保存的路径
        String modelDir = PathKit.getWebRootPath() + "/src/main/java/" + modelPackage.replace(".", "/");
        String baseModelDir = PathKit.getWebRootPath() + "/src/main/java/" + baseModelPackage.replace(".", "/");

        System.out.println("start generate...");
        System.out.println("generate dir:" + modelDir);

        //生成Model和BaseModel
        new JbootBaseModelGenerator(baseModelPackage, baseModelDir).generate();
        new JbootModelGenerator(modelPackage, baseModelPackage, modelDir).generate();

        //设置service层的包名
        String servicePackage = "com.web.generator.service";
        //生成service接口和实现类，实现类以provider命名，可以改为你需要的名称。
        new JbootServiceInterfaceGenerator(servicePackage, modelPackage).generate();
        new JbootServiceImplGenerator(servicePackage , modelPackage).setImplName("impl").generate();
        System.out.println("Task complete.");

    }
}