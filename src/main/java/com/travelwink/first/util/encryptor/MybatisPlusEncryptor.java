package com.travelwink.first.util.encryptor;

import com.baomidou.mybatisplus.core.toolkit.AES;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chris
 */
@Slf4j
public class MybatisPlusEncryptor {

    public static void main(String[] args) {

        // 生成 16 位随机 AES 密钥
        String randomKey = AES.generateRandomKey();
        log.info("randomKey = " + randomKey);

        String key = "ae119551916f74d5";

        String password = "tlqwsrsvywdcgfhg";

        // 随机密钥加密
        String randomResult = AES.encrypt(password, randomKey);
        String keyResult = AES.encrypt(password, key);

        log.info("The result with password: " + password + " and random key: " + randomKey + " is: " + randomResult);
        log.info("The result with password: " + password + " and key: " + key + " is: " + keyResult);

        // Jar 启动参数（ idea 设置 Program arguments , 服务器可以设置为启动环境变量 ）
        // --mpw.key=<key>

        // YML加密配置 mpw: 开头紧接加密内容（ 非数据库配置专用 YML 中其它配置也是可以使用的 ）
        // mpw:<encryptedPassword>

    }

}
