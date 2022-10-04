/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 8.0.28
Source Host           : localhost:3306
Source Database       : endless

Target Server Type    : MYSQL
Target Server Version : 8.0.28
File Encoding         : 65001

Date: 2022-10-04 11:11:46
*/

# 执行SET FOREIGN_KEY_CHECKS=0;禁用外键约束
SET FOREIGN_KEY_CHECKS = 0;
DROP DATABASE IF EXISTS `endless`;

# 设置utf8mb4字符集 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci
CREATE DATABASE `endless` CHARACTER SET utf8 COLLATE utf8_general_ci;

USE `endless`;
-- ----------------------------
-- Table structure for el_user
-- ----------------------------
DROP TABLE IF EXISTS `el_user`;
CREATE TABLE `el_user`
(
    `user_id` BIGINT UNSIGNED AUTO_INCREMENT COMMENT '用户id',
    `account` VARCHAR(20) NOT NULL COMMENT '账号',
    `password` VARCHAR(127) NOT NULL COMMENT '密码',
    `nickname` VARCHAR(50) NOT NULL DEFAULT '默认用户名' COMMENT '昵称',
    `e_mail` VARCHAR(20) NOT NULL DEFAULT ''  COMMENT '电子邮箱',
    `user_role` TINYINT NOT NULL DEFAULT 1 COMMENT '用户角色 1为用户 2为管理员 3 为超级管理员',
    `avatar_url` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '头像路径',
    `sex` TINYINT NOT NULL DEFAULT 1 COMMENT '性别 1/0/-1, 1为男 0为女 -1 为保密',
    `birthday` DATE NOT NULL DEFAULT '1000-01-01' COMMENT '出生日期 当日期为 ’1000-01-01‘时 为用户未设置出生日期 ',
    `per_sign` VARCHAR(127) NOT NULL DEFAULT '' COMMENT '个性签名',
    `rewards_points` INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '积分',
    `exp` INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '经验',
    `tel_phone` VARCHAR(11) NOT NULL DEFAULT '' COMMENT '电话号码',
    `user_state` TINYINT NOT NULL DEFAULT '1'  COMMENT '用户状态 1开启 0禁用',
    `recent_login_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最近登录时间',
    `recent_login_ip` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '最近登录地点',
    `is_deleted` BIT NOT NULL DEFAULT 0 COMMENT '是否删除 0为未删除 1 为删除',
    `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (user_id)
)ENGINE = INNODB COMMENT ='无涯用户表';

DROP TABLE IF EXISTS `el_work`;
CREATE TABLE `el_work`
(
    `work_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '作品id',
    `work_type` TINYINT NOT NULL DEFAULT 1 COMMENT '作品类型 1为文章 2为视频',
    `user_id` BIGINT UNSIGNED NOT NULL COMMENT '用户id',
    `zan_amount` INT NOT NULL DEFAULT 0 COMMENT '赞数',
    `work_url` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '作品存储路径',
    `work_title` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '作品标题',
    `work_introduce` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '作品介绍',
    `work_cover_url` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '作品封面路径',
    `is_deleted` BIT NOT NULL DEFAULT 0 COMMENT '是否删除 0为未删除 1 为删除',
    `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (work_id)
)ENGINE = INNODB COMMENT ='无涯作品表';

DROP TABLE IF EXISTS `el_work_tag`;
CREATE TABLE `el_work_tag`
(
    `work_tag_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '作品标签id',
    `work_tag_name` VARCHAR(30) NOT NULL COMMENT '作品标签名',
    `work_tag_descri` VARCHAR(200) NOT NULL COMMENT '作品标签描述',
    `is_deleted` BIT NOT NULL DEFAULT 0 COMMENT '是否删除 0为未删除 1 为删除',
    `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (work_tag_id)
)ENGINE = INNODB COMMENT ='无涯作品标签表';

DROP TABLE IF EXISTS `el_work_have_tag`;
CREATE TABLE `el_work_have_tag`
(
    `have_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '作品拥有标签id',
    `work_tag_id` BIGINT UNSIGNED NOT NULL COMMENT '作品标签id',
    `work_id` BIGINT UNSIGNED NOT NULL COMMENT '作品id',
    `is_deleted` BIT NOT NULL DEFAULT 0 COMMENT '是否删除 0为未删除 1 为删除',
    `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (have_id)
)ENGINE = INNODB COMMENT ='无涯作品标签拥有表';

DROP TABLE IF EXISTS `el_zan`;
CREATE TABLE `el_zan`
(
    `zan_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '点赞id',
    `work_id` BIGINT UNSIGNED NOT NULL COMMENT '作品id',
    `user_id` BIGINT UNSIGNED NOT NULL COMMENT '用户id',
    `is_deleted` BIT NOT NULL DEFAULT 0 COMMENT '是否删除 0为未删除 1 为删除',
    `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (zan_id)
)ENGINE = INNODB COMMENT ='无涯点赞表';

DROP TABLE IF EXISTS `el_browse`;
CREATE TABLE `el_browse`
(
    `browse_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '浏览id',
    `work_id` BIGINT UNSIGNED NOT NULL COMMENT '作品id',
    `user_id` BIGINT UNSIGNED NOT NULL COMMENT '用户id',
    `is_deleted` BIT NOT NULL DEFAULT 0 COMMENT '是否删除 0为未删除 1 为删除',
    `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (browse_id)
)ENGINE = INNODB COMMENT ='无涯浏览表';

DROP TABLE IF EXISTS `el_collect`;
CREATE TABLE `el_collect`
(
    `collect_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '收藏id',
    `work_id` BIGINT UNSIGNED NOT NULL COMMENT '作品id',
    `user_id` BIGINT UNSIGNED NOT NULL COMMENT '用户id',
    `is_deleted` BIT NOT NULL DEFAULT 0 COMMENT '是否删除 0为未删除 1 为删除',
    `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (collect_id)
)ENGINE = INNODB COMMENT ='无涯收藏表';

DROP TABLE IF EXISTS `el_comment`;
CREATE TABLE `el_comment`
(
    `comment_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '评论id',
    `user_id` BIGINT UNSIGNED NOT NULL COMMENT '用户id',
    `comment_type` TINYINT NOT NULL COMMENT '评论类型',
    `commented_user_id` BIGINT UNSIGNED NOT NULL COMMENT '评论用户id',
    `commented_work_id` BIGINT UNSIGNED NOT NULL COMMENT '被评论id',
    `comment_content` VARCHAR(500) NOT NULL COMMENT '评论内容',
    `is_deleted` BIT NOT NULL DEFAULT 0 COMMENT '是否删除 0为未删除 1 为删除',
    `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (comment_id)
)ENGINE = INNODB COMMENT ='无涯评论表';

DROP TABLE IF EXISTS `el_follow`;
CREATE TABLE `el_follow`
(
    `follow_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '关注id',
    `follow_user_id` BIGINT UNSIGNED NOT NULL COMMENT '关注用户id',
    `followed_user_id` BIGINT UNSIGNED NOT NULL COMMENT '被关注用户id',
    `is_deleted` BIT NOT NULL DEFAULT 0 COMMENT '是否删除 0为未删除 1 为删除',
    `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (follow_id)
)ENGINE = INNODB COMMENT ='无涯关注表';

