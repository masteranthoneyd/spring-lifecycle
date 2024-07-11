plugins {
    java
    idea
    id("org.springframework.boot") version "3.3.1"
    id("io.spring.dependency-management") version "1.1.5"
    id("org.graalvm.buildtools.native") version "0.10.2"
}

group = "com.yangbingdong.spring.explore"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
//    implementation("com.baomidou:mybatis-plus-spring-boot3-starter:3.5.7")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

graalvmNative {
    binaries.all {
        buildArgs.add("-J-Dfile.encoding=UTF-8")
        buildArgs.add("-J-Dstdout.encoding=UTF-8")
        buildArgs.add("-J-Dstderr.encoding=UTF-8")
        buildArgs.add("-J-Dconsole.encoding=UTF-8")
        buildArgs.add("-J-Duser.language=en")
        jvmArgs.add("-Dfile.encoding=UTF-8")
        jvmArgs.add("-Dstdout.encoding=UTF-8")
        jvmArgs.add("-Dstderr.encoding=UTF-8")
        jvmArgs.add("-Dconsole.encoding=UTF-8")
        runtimeArgs.add("-Dfile.encoding=UTF-8")
        runtimeArgs.add("-Dstdout.encoding=UTF-8")
        runtimeArgs.add("-Dstderr.encoding=UTF-8")
        runtimeArgs.add("-Dconsole.encoding=UTF-8")
    }
}

idea {
    module {
        isDownloadSources = true
    }
}
