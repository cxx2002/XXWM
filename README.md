# 嘻嘻外卖


**简介**:嘻嘻外卖

**HOST**:localhost:8181

**联系人**:cxx

**Version**:1.0

**接口路径**:/v2/api-docs

#### 1、介绍

基于Springboot开发的外卖餐购项目（后台管理+消费者端）

#### 2、采用技术栈

前端：Element-ui、Vue
后端：SpringBoot、Mybatisplus、
     Mysql8.0.23(注意和Mysql5的配置有所不同)、
     Swagger、
     Redis6.0+、

#### 3、主要的请求路径：

后端请求:
  后端登录页:  http://localhost:8181/backend/page/login/login.html
  后端主要展示页/主页: http://localhost:8181/backend/index.html
消费端请求:
  消费端登录页: http://localhost:8181/front/page/login.html
  消费端主页: http://localhost:8181/front/index.html
Swagger接口文档的请求: localhost:8181/doc.html#/home

#### 4、项目说明：

在原本项目的基础上，我自行实现了如下功能：
1) 菜品（批量）启售和（批量）停售
2）菜品的批量删除
3）套餐的（批量）启售，停售
4) 套餐管理的修改
5) 后台按条件查看和展示客户订单
6) 手机端减少购物车中的菜品或者套餐数量
7) 用户查看自己订单
8) 移动端点击套餐图片查看套餐具体菜品

9) 再来一单

10).......

注意：启动项目前，需要启动Redis服务，因为项目前端验证码、前后端的菜品、套餐等模块都使用到了Redis。


[TOC]






# address-book-controller


## save


**接口地址**:`/addressBook`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "cityCode": "",
  "cityName": "",
  "consignee": "",
  "createTime": "",
  "createUser": 0,
  "detail": "",
  "districtCode": "",
  "districtName": "",
  "id": 0,
  "isDefault": 0,
  "isDeleted": 0,
  "label": "",
  "phone": "",
  "provinceCode": "",
  "provinceName": "",
  "sex": 0,
  "updateTime": "",
  "updateUser": 0,
  "userId": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|addressBook|addressBook|body|true|AddressBook|AddressBook|
|&emsp;&emsp;cityCode|||false|string||
|&emsp;&emsp;cityName|||false|string||
|&emsp;&emsp;consignee|||false|string||
|&emsp;&emsp;createTime|||false|string(date-time)||
|&emsp;&emsp;createUser|||false|integer(int64)||
|&emsp;&emsp;detail|||false|string||
|&emsp;&emsp;districtCode|||false|string||
|&emsp;&emsp;districtName|||false|string||
|&emsp;&emsp;id|||false|integer(int64)||
|&emsp;&emsp;isDefault|||false|integer(int32)||
|&emsp;&emsp;isDeleted|||false|integer(int32)||
|&emsp;&emsp;label|||false|string||
|&emsp;&emsp;phone|||false|string||
|&emsp;&emsp;provinceCode|||false|string||
|&emsp;&emsp;provinceName|||false|string||
|&emsp;&emsp;sex|||false|integer(int32)||
|&emsp;&emsp;updateTime|||false|string(date-time)||
|&emsp;&emsp;updateUser|||false|integer(int64)||
|&emsp;&emsp;userId|||false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«AddressBook»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||AddressBook|AddressBook|
|&emsp;&emsp;cityCode||string||
|&emsp;&emsp;cityName||string||
|&emsp;&emsp;consignee||string||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;createUser||integer(int64)||
|&emsp;&emsp;detail||string||
|&emsp;&emsp;districtCode||string||
|&emsp;&emsp;districtName||string||
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;isDefault||integer(int32)||
|&emsp;&emsp;isDeleted||integer(int32)||
|&emsp;&emsp;label||string||
|&emsp;&emsp;phone||string||
|&emsp;&emsp;provinceCode||string||
|&emsp;&emsp;provinceName||string||
|&emsp;&emsp;sex||integer(int32)||
|&emsp;&emsp;updateTime||string(date-time)||
|&emsp;&emsp;updateUser||integer(int64)||
|&emsp;&emsp;userId||integer(int64)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"cityCode": "",
		"cityName": "",
		"consignee": "",
		"createTime": "",
		"createUser": 0,
		"detail": "",
		"districtCode": "",
		"districtName": "",
		"id": 0,
		"isDefault": 0,
		"isDeleted": 0,
		"label": "",
		"phone": "",
		"provinceCode": "",
		"provinceName": "",
		"sex": 0,
		"updateTime": "",
		"updateUser": 0,
		"userId": 0
	},
	"map": {},
	"msg": ""
}
```


## deleteById


**接口地址**:`/addressBook`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|query|false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK||
|204|No Content||
|401|Unauthorized||
|403|Forbidden||


**响应参数**:


暂无


**响应示例**:
```javascript

```


## getDefault


**接口地址**:`/addressBook/default`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«AddressBook»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||AddressBook|AddressBook|
|&emsp;&emsp;cityCode||string||
|&emsp;&emsp;cityName||string||
|&emsp;&emsp;consignee||string||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;createUser||integer(int64)||
|&emsp;&emsp;detail||string||
|&emsp;&emsp;districtCode||string||
|&emsp;&emsp;districtName||string||
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;isDefault||integer(int32)||
|&emsp;&emsp;isDeleted||integer(int32)||
|&emsp;&emsp;label||string||
|&emsp;&emsp;phone||string||
|&emsp;&emsp;provinceCode||string||
|&emsp;&emsp;provinceName||string||
|&emsp;&emsp;sex||integer(int32)||
|&emsp;&emsp;updateTime||string(date-time)||
|&emsp;&emsp;updateUser||integer(int64)||
|&emsp;&emsp;userId||integer(int64)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"cityCode": "",
		"cityName": "",
		"consignee": "",
		"createTime": "",
		"createUser": 0,
		"detail": "",
		"districtCode": "",
		"districtName": "",
		"id": 0,
		"isDefault": 0,
		"isDeleted": 0,
		"label": "",
		"phone": "",
		"provinceCode": "",
		"provinceName": "",
		"sex": 0,
		"updateTime": "",
		"updateUser": 0,
		"userId": 0
	},
	"map": {},
	"msg": ""
}
```


## edit


**接口地址**:`/addressBook/default`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "cityCode": "",
  "cityName": "",
  "consignee": "",
  "createTime": "",
  "createUser": 0,
  "detail": "",
  "districtCode": "",
  "districtName": "",
  "id": 0,
  "isDefault": 0,
  "isDeleted": 0,
  "label": "",
  "phone": "",
  "provinceCode": "",
  "provinceName": "",
  "sex": 0,
  "updateTime": "",
  "updateUser": 0,
  "userId": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|addressBook|addressBook|body|true|AddressBook|AddressBook|
|&emsp;&emsp;cityCode|||false|string||
|&emsp;&emsp;cityName|||false|string||
|&emsp;&emsp;consignee|||false|string||
|&emsp;&emsp;createTime|||false|string(date-time)||
|&emsp;&emsp;createUser|||false|integer(int64)||
|&emsp;&emsp;detail|||false|string||
|&emsp;&emsp;districtCode|||false|string||
|&emsp;&emsp;districtName|||false|string||
|&emsp;&emsp;id|||false|integer(int64)||
|&emsp;&emsp;isDefault|||false|integer(int32)||
|&emsp;&emsp;isDeleted|||false|integer(int32)||
|&emsp;&emsp;label|||false|string||
|&emsp;&emsp;phone|||false|string||
|&emsp;&emsp;provinceCode|||false|string||
|&emsp;&emsp;provinceName|||false|string||
|&emsp;&emsp;sex|||false|integer(int32)||
|&emsp;&emsp;updateTime|||false|string(date-time)||
|&emsp;&emsp;updateUser|||false|integer(int64)||
|&emsp;&emsp;userId|||false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«AddressBook»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||AddressBook|AddressBook|
|&emsp;&emsp;cityCode||string||
|&emsp;&emsp;cityName||string||
|&emsp;&emsp;consignee||string||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;createUser||integer(int64)||
|&emsp;&emsp;detail||string||
|&emsp;&emsp;districtCode||string||
|&emsp;&emsp;districtName||string||
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;isDefault||integer(int32)||
|&emsp;&emsp;isDeleted||integer(int32)||
|&emsp;&emsp;label||string||
|&emsp;&emsp;phone||string||
|&emsp;&emsp;provinceCode||string||
|&emsp;&emsp;provinceName||string||
|&emsp;&emsp;sex||integer(int32)||
|&emsp;&emsp;updateTime||string(date-time)||
|&emsp;&emsp;updateUser||integer(int64)||
|&emsp;&emsp;userId||integer(int64)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"cityCode": "",
		"cityName": "",
		"consignee": "",
		"createTime": "",
		"createUser": 0,
		"detail": "",
		"districtCode": "",
		"districtName": "",
		"id": 0,
		"isDefault": 0,
		"isDeleted": 0,
		"label": "",
		"phone": "",
		"provinceCode": "",
		"provinceName": "",
		"sex": 0,
		"updateTime": "",
		"updateUser": 0,
		"userId": 0
	},
	"map": {},
	"msg": ""
}
```


## list


**接口地址**:`/addressBook/list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|cityCode||query|false|string||
|cityName||query|false|string||
|consignee||query|false|string||
|createTime||query|false|string(date-time)||
|createUser||query|false|integer(int64)||
|detail||query|false|string||
|districtCode||query|false|string||
|districtName||query|false|string||
|id||query|false|integer(int64)||
|isDefault||query|false|integer(int32)||
|isDeleted||query|false|integer(int32)||
|label||query|false|string||
|phone||query|false|string||
|provinceCode||query|false|string||
|provinceName||query|false|string||
|sex||query|false|integer(int32)||
|updateTime||query|false|string(date-time)||
|updateUser||query|false|integer(int64)||
|userId||query|false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«List«AddressBook»»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||array|AddressBook|
|&emsp;&emsp;cityCode||string||
|&emsp;&emsp;cityName||string||
|&emsp;&emsp;consignee||string||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;createUser||integer(int64)||
|&emsp;&emsp;detail||string||
|&emsp;&emsp;districtCode||string||
|&emsp;&emsp;districtName||string||
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;isDefault||integer(int32)||
|&emsp;&emsp;isDeleted||integer(int32)||
|&emsp;&emsp;label||string||
|&emsp;&emsp;phone||string||
|&emsp;&emsp;provinceCode||string||
|&emsp;&emsp;provinceName||string||
|&emsp;&emsp;sex||integer(int32)||
|&emsp;&emsp;updateTime||string(date-time)||
|&emsp;&emsp;updateUser||integer(int64)||
|&emsp;&emsp;userId||integer(int64)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": [
		{
			"cityCode": "",
			"cityName": "",
			"consignee": "",
			"createTime": "",
			"createUser": 0,
			"detail": "",
			"districtCode": "",
			"districtName": "",
			"id": 0,
			"isDefault": 0,
			"isDeleted": 0,
			"label": "",
			"phone": "",
			"provinceCode": "",
			"provinceName": "",
			"sex": 0,
			"updateTime": "",
			"updateUser": 0,
			"userId": 0
		}
	],
	"map": {},
	"msg": ""
}
```


## queryById


**接口地址**:`/addressBook/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||object||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"map": {},
	"msg": ""
}
```


# category-controller


## save


**接口地址**:`/category`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "createTime": "",
  "createUser": 0,
  "id": 0,
  "name": "",
  "sort": 0,
  "type": 0,
  "updateTime": "",
  "updateUser": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|category|category|body|true|Category|Category|
|&emsp;&emsp;createTime|||false|string(date-time)||
|&emsp;&emsp;createUser|||false|integer(int64)||
|&emsp;&emsp;id|||false|integer(int64)||
|&emsp;&emsp;name|||false|string||
|&emsp;&emsp;sort|||false|integer(int32)||
|&emsp;&emsp;type|||false|integer(int32)||
|&emsp;&emsp;updateTime|||false|string(date-time)||
|&emsp;&emsp;updateUser|||false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## edit


**接口地址**:`/category`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "createTime": "",
  "createUser": 0,
  "id": 0,
  "name": "",
  "sort": 0,
  "type": 0,
  "updateTime": "",
  "updateUser": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|category|category|body|true|Category|Category|
|&emsp;&emsp;createTime|||false|string(date-time)||
|&emsp;&emsp;createUser|||false|integer(int64)||
|&emsp;&emsp;id|||false|integer(int64)||
|&emsp;&emsp;name|||false|string||
|&emsp;&emsp;sort|||false|integer(int32)||
|&emsp;&emsp;type|||false|integer(int32)||
|&emsp;&emsp;updateTime|||false|string(date-time)||
|&emsp;&emsp;updateUser|||false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## deleteById


**接口地址**:`/category`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|query|false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«string»|
|204|No Content||
|401|Unauthorized||
|403|Forbidden||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## queryById


**接口地址**:`/category/list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|createTime||query|false|string(date-time)||
|createUser||query|false|integer(int64)||
|id||query|false|integer(int64)||
|name||query|false|string||
|sort||query|false|integer(int32)||
|type||query|false|integer(int32)||
|updateTime||query|false|string(date-time)||
|updateUser||query|false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«List«Category»»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||array|Category|
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;createUser||integer(int64)||
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;name||string||
|&emsp;&emsp;sort||integer(int32)||
|&emsp;&emsp;type||integer(int32)||
|&emsp;&emsp;updateTime||string(date-time)||
|&emsp;&emsp;updateUser||integer(int64)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": [
		{
			"createTime": "",
			"createUser": 0,
			"id": 0,
			"name": "",
			"sort": 0,
			"type": 0,
			"updateTime": "",
			"updateUser": 0
		}
	],
	"map": {},
	"msg": ""
}
```


## queryByPage


**接口地址**:`/category/page`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|page|page|query|false|integer(int32)||
|pageSize|pageSize|query|false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«Page«Category»»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||Page«Category»|Page«Category»|
|&emsp;&emsp;countId||string||
|&emsp;&emsp;current||integer(int64)||
|&emsp;&emsp;maxLimit||integer(int64)||
|&emsp;&emsp;optimizeCountSql||boolean||
|&emsp;&emsp;orders||array|OrderItem|
|&emsp;&emsp;&emsp;&emsp;asc||boolean||
|&emsp;&emsp;&emsp;&emsp;column||string||
|&emsp;&emsp;pages||integer(int64)||
|&emsp;&emsp;records||array|Category|
|&emsp;&emsp;&emsp;&emsp;createTime||string||
|&emsp;&emsp;&emsp;&emsp;createUser||integer||
|&emsp;&emsp;&emsp;&emsp;id||integer||
|&emsp;&emsp;&emsp;&emsp;name||string||
|&emsp;&emsp;&emsp;&emsp;sort||integer||
|&emsp;&emsp;&emsp;&emsp;type||integer||
|&emsp;&emsp;&emsp;&emsp;updateTime||string||
|&emsp;&emsp;&emsp;&emsp;updateUser||integer||
|&emsp;&emsp;searchCount||boolean||
|&emsp;&emsp;size||integer(int64)||
|&emsp;&emsp;total||integer(int64)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"countId": "",
		"current": 0,
		"maxLimit": 0,
		"optimizeCountSql": true,
		"orders": [
			{
				"asc": true,
				"column": ""
			}
		],
		"pages": 0,
		"records": [
			{
				"createTime": "",
				"createUser": 0,
				"id": 0,
				"name": "",
				"sort": 0,
				"type": 0,
				"updateTime": "",
				"updateUser": 0
			}
		],
		"searchCount": true,
		"size": 0,
		"total": 0
	},
	"map": {},
	"msg": ""
}
```


# common-controller


## downLoad


**接口地址**:`/common/download`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|name|name|query|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


暂无


**响应示例**:
```javascript

```


## upload


**接口地址**:`/common/upload`


**请求方式**:`POST`


**请求数据类型**:`multipart/form-data`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|file||formData|false|file||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


# employee-controller


## save


**接口地址**:`/employee`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "createTime": "",
  "createUser": 0,
  "id": "",
  "idNumber": "",
  "name": "",
  "password": "",
  "phone": "",
  "sex": "",
  "status": 0,
  "updateTime": "",
  "updateUser": 0,
  "username": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|employee|employee|body|true|Employee|Employee|
|&emsp;&emsp;createTime|||false|string(date-time)||
|&emsp;&emsp;createUser|||false|integer(int64)||
|&emsp;&emsp;id|||false|string||
|&emsp;&emsp;idNumber|||false|string||
|&emsp;&emsp;name|||false|string||
|&emsp;&emsp;password|||false|string||
|&emsp;&emsp;phone|||false|string||
|&emsp;&emsp;sex|||false|string||
|&emsp;&emsp;status|||false|integer(int32)||
|&emsp;&emsp;updateTime|||false|string(date-time)||
|&emsp;&emsp;updateUser|||false|integer(int64)||
|&emsp;&emsp;username|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## update


**接口地址**:`/employee`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "createTime": "",
  "createUser": 0,
  "id": "",
  "idNumber": "",
  "name": "",
  "password": "",
  "phone": "",
  "sex": "",
  "status": 0,
  "updateTime": "",
  "updateUser": 0,
  "username": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|employee|employee|body|true|Employee|Employee|
|&emsp;&emsp;createTime|||false|string(date-time)||
|&emsp;&emsp;createUser|||false|integer(int64)||
|&emsp;&emsp;id|||false|string||
|&emsp;&emsp;idNumber|||false|string||
|&emsp;&emsp;name|||false|string||
|&emsp;&emsp;password|||false|string||
|&emsp;&emsp;phone|||false|string||
|&emsp;&emsp;sex|||false|string||
|&emsp;&emsp;status|||false|integer(int32)||
|&emsp;&emsp;updateTime|||false|string(date-time)||
|&emsp;&emsp;updateUser|||false|integer(int64)||
|&emsp;&emsp;username|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## deleteById


**接口地址**:`/employee`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|query|false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK||
|204|No Content||
|401|Unauthorized||
|403|Forbidden||


**响应参数**:


暂无


**响应示例**:
```javascript

```


## login


**接口地址**:`/employee/login`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "createTime": "",
  "createUser": 0,
  "id": "",
  "idNumber": "",
  "name": "",
  "password": "",
  "phone": "",
  "sex": "",
  "status": 0,
  "updateTime": "",
  "updateUser": 0,
  "username": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|employee|employee|body|true|Employee|Employee|
|&emsp;&emsp;createTime|||false|string(date-time)||
|&emsp;&emsp;createUser|||false|integer(int64)||
|&emsp;&emsp;id|||false|string||
|&emsp;&emsp;idNumber|||false|string||
|&emsp;&emsp;name|||false|string||
|&emsp;&emsp;password|||false|string||
|&emsp;&emsp;phone|||false|string||
|&emsp;&emsp;sex|||false|string||
|&emsp;&emsp;status|||false|integer(int32)||
|&emsp;&emsp;updateTime|||false|string(date-time)||
|&emsp;&emsp;updateUser|||false|integer(int64)||
|&emsp;&emsp;username|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«Employee»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||Employee|Employee|
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;createUser||integer(int64)||
|&emsp;&emsp;id||string||
|&emsp;&emsp;idNumber||string||
|&emsp;&emsp;name||string||
|&emsp;&emsp;password||string||
|&emsp;&emsp;phone||string||
|&emsp;&emsp;sex||string||
|&emsp;&emsp;status||integer(int32)||
|&emsp;&emsp;updateTime||string(date-time)||
|&emsp;&emsp;updateUser||integer(int64)||
|&emsp;&emsp;username||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"createTime": "",
		"createUser": 0,
		"id": "",
		"idNumber": "",
		"name": "",
		"password": "",
		"phone": "",
		"sex": "",
		"status": 0,
		"updateTime": "",
		"updateUser": 0,
		"username": ""
	},
	"map": {},
	"msg": ""
}
```


## logout


**接口地址**:`/employee/logout`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## queryByPage


**接口地址**:`/employee/page`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|name|name|query|false|string||
|page|page|query|false|integer(int32)||
|pageSize|pageSize|query|false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«Page«Employee»»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||Page«Employee»|Page«Employee»|
|&emsp;&emsp;countId||string||
|&emsp;&emsp;current||integer(int64)||
|&emsp;&emsp;maxLimit||integer(int64)||
|&emsp;&emsp;optimizeCountSql||boolean||
|&emsp;&emsp;orders||array|OrderItem|
|&emsp;&emsp;&emsp;&emsp;asc||boolean||
|&emsp;&emsp;&emsp;&emsp;column||string||
|&emsp;&emsp;pages||integer(int64)||
|&emsp;&emsp;records||array|Employee|
|&emsp;&emsp;&emsp;&emsp;createTime||string||
|&emsp;&emsp;&emsp;&emsp;createUser||integer||
|&emsp;&emsp;&emsp;&emsp;id||string||
|&emsp;&emsp;&emsp;&emsp;idNumber||string||
|&emsp;&emsp;&emsp;&emsp;name||string||
|&emsp;&emsp;&emsp;&emsp;password||string||
|&emsp;&emsp;&emsp;&emsp;phone||string||
|&emsp;&emsp;&emsp;&emsp;sex||string||
|&emsp;&emsp;&emsp;&emsp;status||integer||
|&emsp;&emsp;&emsp;&emsp;updateTime||string||
|&emsp;&emsp;&emsp;&emsp;updateUser||integer||
|&emsp;&emsp;&emsp;&emsp;username||string||
|&emsp;&emsp;searchCount||boolean||
|&emsp;&emsp;size||integer(int64)||
|&emsp;&emsp;total||integer(int64)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"countId": "",
		"current": 0,
		"maxLimit": 0,
		"optimizeCountSql": true,
		"orders": [
			{
				"asc": true,
				"column": ""
			}
		],
		"pages": 0,
		"records": [
			{
				"createTime": "",
				"createUser": 0,
				"id": "",
				"idNumber": "",
				"name": "",
				"password": "",
				"phone": "",
				"sex": "",
				"status": 0,
				"updateTime": "",
				"updateUser": 0,
				"username": ""
			}
		],
		"searchCount": true,
		"size": 0,
		"total": 0
	},
	"map": {},
	"msg": ""
}
```


## queryById


**接口地址**:`/employee/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«Employee»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||Employee|Employee|
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;createUser||integer(int64)||
|&emsp;&emsp;id||string||
|&emsp;&emsp;idNumber||string||
|&emsp;&emsp;name||string||
|&emsp;&emsp;password||string||
|&emsp;&emsp;phone||string||
|&emsp;&emsp;sex||string||
|&emsp;&emsp;status||integer(int32)||
|&emsp;&emsp;updateTime||string(date-time)||
|&emsp;&emsp;updateUser||integer(int64)||
|&emsp;&emsp;username||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"createTime": "",
		"createUser": 0,
		"id": "",
		"idNumber": "",
		"name": "",
		"password": "",
		"phone": "",
		"sex": "",
		"status": 0,
		"updateTime": "",
		"updateUser": 0,
		"username": ""
	},
	"map": {},
	"msg": ""
}
```


# order-detail-controller


## queryByPage


**接口地址**:`/orderDetail`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|amount||query|false|number||
|dishFlavor||query|false|string||
|dishId||query|false|integer(int64)||
|id||query|false|integer(int64)||
|image||query|false|string||
|isDeleted||query|false|integer(int32)||
|name||query|false|string||
|number||query|false|integer(int32)||
|offset||query|false|integer(int64)||
|orderId||query|false|integer(int64)||
|pageNumber||query|false|integer(int32)||
|pageSize||query|false|integer(int32)||
|setmealId||query|false|integer(int64)||
|sort.sorted||query|false|boolean||
|sort.unsorted||query|false|boolean||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|Page«OrderDetail»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|countId||string||
|current||integer(int64)|integer(int64)|
|maxLimit||integer(int64)|integer(int64)|
|optimizeCountSql||boolean||
|orders||array|OrderItem|
|&emsp;&emsp;asc||boolean||
|&emsp;&emsp;column||string||
|pages||integer(int64)|integer(int64)|
|records||array|OrderDetail|
|&emsp;&emsp;amount||number||
|&emsp;&emsp;dishFlavor||string||
|&emsp;&emsp;dishId||integer(int64)||
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;image||string||
|&emsp;&emsp;isDeleted||integer(int32)||
|&emsp;&emsp;name||string||
|&emsp;&emsp;number||integer(int32)||
|&emsp;&emsp;orderId||integer(int64)||
|&emsp;&emsp;setmealId||integer(int64)||
|searchCount||boolean||
|size||integer(int64)|integer(int64)|
|total||integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"countId": "",
	"current": 0,
	"maxLimit": 0,
	"optimizeCountSql": true,
	"orders": [
		{
			"asc": true,
			"column": ""
		}
	],
	"pages": 0,
	"records": [
		{
			"amount": 0,
			"dishFlavor": "",
			"dishId": 0,
			"id": 0,
			"image": "",
			"isDeleted": 0,
			"name": "",
			"number": 0,
			"orderId": 0,
			"setmealId": 0
		}
	],
	"searchCount": true,
	"size": 0,
	"total": 0
}
```


## add


**接口地址**:`/orderDetail`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "amount": 0,
  "dishFlavor": "",
  "dishId": 0,
  "id": 0,
  "image": "",
  "isDeleted": 0,
  "name": "",
  "number": 0,
  "orderId": 0,
  "setmealId": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|orderDetail|orderDetail|body|true|OrderDetail|OrderDetail|
|&emsp;&emsp;amount|||false|number||
|&emsp;&emsp;dishFlavor|||false|string||
|&emsp;&emsp;dishId|||false|integer(int64)||
|&emsp;&emsp;id|||false|integer(int64)||
|&emsp;&emsp;image|||false|string||
|&emsp;&emsp;isDeleted|||false|integer(int32)||
|&emsp;&emsp;name|||false|string||
|&emsp;&emsp;number|||false|integer(int32)||
|&emsp;&emsp;orderId|||false|integer(int64)||
|&emsp;&emsp;setmealId|||false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|OrderDetail|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|amount||number||
|dishFlavor||string||
|dishId||integer(int64)|integer(int64)|
|id||integer(int64)|integer(int64)|
|image||string||
|isDeleted||integer(int32)|integer(int32)|
|name||string||
|number||integer(int32)|integer(int32)|
|orderId||integer(int64)|integer(int64)|
|setmealId||integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"amount": 0,
	"dishFlavor": "",
	"dishId": 0,
	"id": 0,
	"image": "",
	"isDeleted": 0,
	"name": "",
	"number": 0,
	"orderId": 0,
	"setmealId": 0
}
```


## edit


**接口地址**:`/orderDetail`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "amount": 0,
  "dishFlavor": "",
  "dishId": 0,
  "id": 0,
  "image": "",
  "isDeleted": 0,
  "name": "",
  "number": 0,
  "orderId": 0,
  "setmealId": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|orderDetail|orderDetail|body|true|OrderDetail|OrderDetail|
|&emsp;&emsp;amount|||false|number||
|&emsp;&emsp;dishFlavor|||false|string||
|&emsp;&emsp;dishId|||false|integer(int64)||
|&emsp;&emsp;id|||false|integer(int64)||
|&emsp;&emsp;image|||false|string||
|&emsp;&emsp;isDeleted|||false|integer(int32)||
|&emsp;&emsp;name|||false|string||
|&emsp;&emsp;number|||false|integer(int32)||
|&emsp;&emsp;orderId|||false|integer(int64)||
|&emsp;&emsp;setmealId|||false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|OrderDetail|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|amount||number||
|dishFlavor||string||
|dishId||integer(int64)|integer(int64)|
|id||integer(int64)|integer(int64)|
|image||string||
|isDeleted||integer(int32)|integer(int32)|
|name||string||
|number||integer(int32)|integer(int32)|
|orderId||integer(int64)|integer(int64)|
|setmealId||integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"amount": 0,
	"dishFlavor": "",
	"dishId": 0,
	"id": 0,
	"image": "",
	"isDeleted": 0,
	"name": "",
	"number": 0,
	"orderId": 0,
	"setmealId": 0
}
```


## deleteById


**接口地址**:`/orderDetail`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|query|false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK||
|204|No Content||
|401|Unauthorized||
|403|Forbidden||


**响应参数**:


暂无


**响应示例**:
```javascript

```


## queryById


**接口地址**:`/orderDetail/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|OrderDetail|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|amount||number||
|dishFlavor||string||
|dishId||integer(int64)|integer(int64)|
|id||integer(int64)|integer(int64)|
|image||string||
|isDeleted||integer(int32)|integer(int32)|
|name||string||
|number||integer(int32)|integer(int32)|
|orderId||integer(int64)|integer(int64)|
|setmealId||integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"amount": 0,
	"dishFlavor": "",
	"dishId": 0,
	"id": 0,
	"image": "",
	"isDeleted": 0,
	"name": "",
	"number": 0,
	"orderId": 0,
	"setmealId": 0
}
```


# orders-controller


## edit


**接口地址**:`/order`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "address": "",
  "addressBookId": 0,
  "amount": 0,
  "checkoutTime": "",
  "consignee": "",
  "id": 0,
  "isDeleted": 0,
  "number": "",
  "orderTime": "",
  "payMethod": 0,
  "phone": "",
  "remark": "",
  "status": 0,
  "userId": 0,
  "userName": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|orders|orders|body|true|Orders|Orders|
|&emsp;&emsp;address|||false|string||
|&emsp;&emsp;addressBookId|||false|integer(int64)||
|&emsp;&emsp;amount|||false|number||
|&emsp;&emsp;checkoutTime|||false|string(date-time)||
|&emsp;&emsp;consignee|||false|string||
|&emsp;&emsp;id|||false|integer(int64)||
|&emsp;&emsp;isDeleted|||false|integer(int32)||
|&emsp;&emsp;number|||false|string||
|&emsp;&emsp;orderTime|||false|string(date-time)||
|&emsp;&emsp;payMethod|||false|integer(int32)||
|&emsp;&emsp;phone|||false|string||
|&emsp;&emsp;remark|||false|string||
|&emsp;&emsp;status|||false|integer(int32)||
|&emsp;&emsp;userId|||false|integer(int64)||
|&emsp;&emsp;userName|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## deleteById


**接口地址**:`/order`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|query|false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK||
|204|No Content||
|401|Unauthorized||
|403|Forbidden||


**响应参数**:


暂无


**响应示例**:
```javascript

```


## again


**接口地址**:`/order/again`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "address": "",
  "addressBookId": 0,
  "amount": 0,
  "checkoutTime": "",
  "consignee": "",
  "id": 0,
  "isDeleted": 0,
  "number": "",
  "orderTime": "",
  "payMethod": 0,
  "phone": "",
  "remark": "",
  "status": 0,
  "userId": 0,
  "userName": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|orders|orders|body|true|Orders|Orders|
|&emsp;&emsp;address|||false|string||
|&emsp;&emsp;addressBookId|||false|integer(int64)||
|&emsp;&emsp;amount|||false|number||
|&emsp;&emsp;checkoutTime|||false|string(date-time)||
|&emsp;&emsp;consignee|||false|string||
|&emsp;&emsp;id|||false|integer(int64)||
|&emsp;&emsp;isDeleted|||false|integer(int32)||
|&emsp;&emsp;number|||false|string||
|&emsp;&emsp;orderTime|||false|string(date-time)||
|&emsp;&emsp;payMethod|||false|integer(int32)||
|&emsp;&emsp;phone|||false|string||
|&emsp;&emsp;remark|||false|string||
|&emsp;&emsp;status|||false|integer(int32)||
|&emsp;&emsp;userId|||false|integer(int64)||
|&emsp;&emsp;userName|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## showPage


**接口地址**:`/order/page`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|beginTime|beginTime|query|false|string||
|endTime|endTime|query|false|string||
|number|number|query|false|integer(int64)||
|page|page|query|false|integer(int32)||
|pageSize|pageSize|query|false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«Page»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||Page|Page|
|&emsp;&emsp;countId||string||
|&emsp;&emsp;current||integer(int64)||
|&emsp;&emsp;maxLimit||integer(int64)||
|&emsp;&emsp;optimizeCountSql||boolean||
|&emsp;&emsp;orders||array|OrderItem|
|&emsp;&emsp;&emsp;&emsp;asc||boolean||
|&emsp;&emsp;&emsp;&emsp;column||string||
|&emsp;&emsp;pages||integer(int64)||
|&emsp;&emsp;records||array|object|
|&emsp;&emsp;searchCount||boolean||
|&emsp;&emsp;size||integer(int64)||
|&emsp;&emsp;total||integer(int64)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"countId": "",
		"current": 0,
		"maxLimit": 0,
		"optimizeCountSql": true,
		"orders": [
			{
				"asc": true,
				"column": ""
			}
		],
		"pages": 0,
		"records": [],
		"searchCount": true,
		"size": 0,
		"total": 0
	},
	"map": {},
	"msg": ""
}
```


## submit


**接口地址**:`/order/submit`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "address": "",
  "addressBookId": 0,
  "amount": 0,
  "checkoutTime": "",
  "consignee": "",
  "id": 0,
  "isDeleted": 0,
  "number": "",
  "orderTime": "",
  "payMethod": 0,
  "phone": "",
  "remark": "",
  "status": 0,
  "userId": 0,
  "userName": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|orders|orders|body|true|Orders|Orders|
|&emsp;&emsp;address|||false|string||
|&emsp;&emsp;addressBookId|||false|integer(int64)||
|&emsp;&emsp;amount|||false|number||
|&emsp;&emsp;checkoutTime|||false|string(date-time)||
|&emsp;&emsp;consignee|||false|string||
|&emsp;&emsp;id|||false|integer(int64)||
|&emsp;&emsp;isDeleted|||false|integer(int32)||
|&emsp;&emsp;number|||false|string||
|&emsp;&emsp;orderTime|||false|string(date-time)||
|&emsp;&emsp;payMethod|||false|integer(int32)||
|&emsp;&emsp;phone|||false|string||
|&emsp;&emsp;remark|||false|string||
|&emsp;&emsp;status|||false|integer(int32)||
|&emsp;&emsp;userId|||false|integer(int64)||
|&emsp;&emsp;userName|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## userPage


**接口地址**:`/order/userPage`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|page|page|query|false|integer(int32)||
|pageSize|pageSize|query|false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«Page»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||Page|Page|
|&emsp;&emsp;countId||string||
|&emsp;&emsp;current||integer(int64)||
|&emsp;&emsp;maxLimit||integer(int64)||
|&emsp;&emsp;optimizeCountSql||boolean||
|&emsp;&emsp;orders||array|OrderItem|
|&emsp;&emsp;&emsp;&emsp;asc||boolean||
|&emsp;&emsp;&emsp;&emsp;column||string||
|&emsp;&emsp;pages||integer(int64)||
|&emsp;&emsp;records||array|object|
|&emsp;&emsp;searchCount||boolean||
|&emsp;&emsp;size||integer(int64)||
|&emsp;&emsp;total||integer(int64)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"countId": "",
		"current": 0,
		"maxLimit": 0,
		"optimizeCountSql": true,
		"orders": [
			{
				"asc": true,
				"column": ""
			}
		],
		"pages": 0,
		"records": [],
		"searchCount": true,
		"size": 0,
		"total": 0
	},
	"map": {},
	"msg": ""
}
```


## queryById


**接口地址**:`/order/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|Orders|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|address||string||
|addressBookId||integer(int64)|integer(int64)|
|amount||number||
|checkoutTime||string(date-time)|string(date-time)|
|consignee||string||
|id||integer(int64)|integer(int64)|
|isDeleted||integer(int32)|integer(int32)|
|number||string||
|orderTime||string(date-time)|string(date-time)|
|payMethod||integer(int32)|integer(int32)|
|phone||string||
|remark||string||
|status||integer(int32)|integer(int32)|
|userId||integer(int64)|integer(int64)|
|userName||string||


**响应示例**:
```javascript
{
	"address": "",
	"addressBookId": 0,
	"amount": 0,
	"checkoutTime": "",
	"consignee": "",
	"id": 0,
	"isDeleted": 0,
	"number": "",
	"orderTime": "",
	"payMethod": 0,
	"phone": "",
	"remark": "",
	"status": 0,
	"userId": 0,
	"userName": ""
}
```


# setmeal-controller


## add


**接口地址**:`/setmeal`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "categoryId": 0,
  "categoryName": "",
  "code": "",
  "createTime": "",
  "createUser": 0,
  "description": "",
  "id": 0,
  "image": "",
  "isDeleted": 0,
  "name": "",
  "price": 0,
  "setmealDishes": [
    {
      "copies": 0,
      "createTime": "",
      "createUser": 0,
      "dishId": "",
      "id": 0,
      "isDeleted": 0,
      "name": "",
      "price": 0,
      "setmealId": "",
      "sort": 0,
      "updateTime": "",
      "updateUser": 0
    }
  ],
  "status": 0,
  "updateTime": "",
  "updateUser": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|setmealDto|setmealDto|body|true|SetmealDto|SetmealDto|
|&emsp;&emsp;categoryId|||false|integer(int64)||
|&emsp;&emsp;categoryName|||false|string||
|&emsp;&emsp;code|||false|string||
|&emsp;&emsp;createTime|||false|string(date-time)||
|&emsp;&emsp;createUser|||false|integer(int64)||
|&emsp;&emsp;description|||false|string||
|&emsp;&emsp;id|||false|integer(int64)||
|&emsp;&emsp;image|||false|string||
|&emsp;&emsp;isDeleted|||false|integer(int32)||
|&emsp;&emsp;name|||false|string||
|&emsp;&emsp;price|||false|number||
|&emsp;&emsp;setmealDishes|||false|array|SetmealDish|
|&emsp;&emsp;&emsp;&emsp;copies|||false|integer||
|&emsp;&emsp;&emsp;&emsp;createTime|||false|string||
|&emsp;&emsp;&emsp;&emsp;createUser|||false|integer||
|&emsp;&emsp;&emsp;&emsp;dishId|||false|string||
|&emsp;&emsp;&emsp;&emsp;id|||false|integer||
|&emsp;&emsp;&emsp;&emsp;isDeleted|||false|integer||
|&emsp;&emsp;&emsp;&emsp;name|||false|string||
|&emsp;&emsp;&emsp;&emsp;price|||false|number||
|&emsp;&emsp;&emsp;&emsp;setmealId|||false|string||
|&emsp;&emsp;&emsp;&emsp;sort|||false|integer||
|&emsp;&emsp;&emsp;&emsp;updateTime|||false|string||
|&emsp;&emsp;&emsp;&emsp;updateUser|||false|integer||
|&emsp;&emsp;status|||false|integer(int32)||
|&emsp;&emsp;updateTime|||false|string(date-time)||
|&emsp;&emsp;updateUser|||false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## edit


**接口地址**:`/setmeal`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "categoryId": 0,
  "categoryName": "",
  "code": "",
  "createTime": "",
  "createUser": 0,
  "description": "",
  "id": 0,
  "image": "",
  "isDeleted": 0,
  "name": "",
  "price": 0,
  "setmealDishes": [
    {
      "copies": 0,
      "createTime": "",
      "createUser": 0,
      "dishId": "",
      "id": 0,
      "isDeleted": 0,
      "name": "",
      "price": 0,
      "setmealId": "",
      "sort": 0,
      "updateTime": "",
      "updateUser": 0
    }
  ],
  "status": 0,
  "updateTime": "",
  "updateUser": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|setmealDto|setmealDto|body|true|SetmealDto|SetmealDto|
|&emsp;&emsp;categoryId|||false|integer(int64)||
|&emsp;&emsp;categoryName|||false|string||
|&emsp;&emsp;code|||false|string||
|&emsp;&emsp;createTime|||false|string(date-time)||
|&emsp;&emsp;createUser|||false|integer(int64)||
|&emsp;&emsp;description|||false|string||
|&emsp;&emsp;id|||false|integer(int64)||
|&emsp;&emsp;image|||false|string||
|&emsp;&emsp;isDeleted|||false|integer(int32)||
|&emsp;&emsp;name|||false|string||
|&emsp;&emsp;price|||false|number||
|&emsp;&emsp;setmealDishes|||false|array|SetmealDish|
|&emsp;&emsp;&emsp;&emsp;copies|||false|integer||
|&emsp;&emsp;&emsp;&emsp;createTime|||false|string||
|&emsp;&emsp;&emsp;&emsp;createUser|||false|integer||
|&emsp;&emsp;&emsp;&emsp;dishId|||false|string||
|&emsp;&emsp;&emsp;&emsp;id|||false|integer||
|&emsp;&emsp;&emsp;&emsp;isDeleted|||false|integer||
|&emsp;&emsp;&emsp;&emsp;name|||false|string||
|&emsp;&emsp;&emsp;&emsp;price|||false|number||
|&emsp;&emsp;&emsp;&emsp;setmealId|||false|string||
|&emsp;&emsp;&emsp;&emsp;sort|||false|integer||
|&emsp;&emsp;&emsp;&emsp;updateTime|||false|string||
|&emsp;&emsp;&emsp;&emsp;updateUser|||false|integer||
|&emsp;&emsp;status|||false|integer(int32)||
|&emsp;&emsp;updateTime|||false|string(date-time)||
|&emsp;&emsp;updateUser|||false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## deleteById


**接口地址**:`/setmeal`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|query|true|array|integer|


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«string»|
|204|No Content||
|401|Unauthorized||
|403|Forbidden||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## queryDishById


**接口地址**:`/setmeal/dish/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«SetmealDto»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||SetmealDto|SetmealDto|
|&emsp;&emsp;categoryId||integer(int64)||
|&emsp;&emsp;categoryName||string||
|&emsp;&emsp;code||string||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;createUser||integer(int64)||
|&emsp;&emsp;description||string||
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;image||string||
|&emsp;&emsp;isDeleted||integer(int32)||
|&emsp;&emsp;name||string||
|&emsp;&emsp;price||number||
|&emsp;&emsp;setmealDishes||array|SetmealDish|
|&emsp;&emsp;&emsp;&emsp;copies||integer||
|&emsp;&emsp;&emsp;&emsp;createTime||string||
|&emsp;&emsp;&emsp;&emsp;createUser||integer||
|&emsp;&emsp;&emsp;&emsp;dishId||string||
|&emsp;&emsp;&emsp;&emsp;id||integer||
|&emsp;&emsp;&emsp;&emsp;isDeleted||integer||
|&emsp;&emsp;&emsp;&emsp;name||string||
|&emsp;&emsp;&emsp;&emsp;price||number||
|&emsp;&emsp;&emsp;&emsp;setmealId||string||
|&emsp;&emsp;&emsp;&emsp;sort||integer||
|&emsp;&emsp;&emsp;&emsp;updateTime||string||
|&emsp;&emsp;&emsp;&emsp;updateUser||integer||
|&emsp;&emsp;status||integer(int32)||
|&emsp;&emsp;updateTime||string(date-time)||
|&emsp;&emsp;updateUser||integer(int64)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"categoryId": 0,
		"categoryName": "",
		"code": "",
		"createTime": "",
		"createUser": 0,
		"description": "",
		"id": 0,
		"image": "",
		"isDeleted": 0,
		"name": "",
		"price": 0,
		"setmealDishes": [
			{
				"copies": 0,
				"createTime": "",
				"createUser": 0,
				"dishId": "",
				"id": 0,
				"isDeleted": 0,
				"name": "",
				"price": 0,
				"setmealId": "",
				"sort": 0,
				"updateTime": "",
				"updateUser": 0
			}
		],
		"status": 0,
		"updateTime": "",
		"updateUser": 0
	},
	"map": {},
	"msg": ""
}
```


## queryDishById


**接口地址**:`/setmeal/list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|categoryId||query|false|integer(int64)||
|code||query|false|string||
|createTime||query|false|string(date-time)||
|createUser||query|false|integer(int64)||
|description||query|false|string||
|id||query|false|integer(int64)||
|image||query|false|string||
|isDeleted||query|false|integer(int32)||
|name||query|false|string||
|price||query|false|number||
|status||query|false|integer(int32)||
|updateTime||query|false|string(date-time)||
|updateUser||query|false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«List«Setmeal»»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||array|Setmeal|
|&emsp;&emsp;categoryId||integer(int64)||
|&emsp;&emsp;code||string||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;createUser||integer(int64)||
|&emsp;&emsp;description||string||
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;image||string||
|&emsp;&emsp;isDeleted||integer(int32)||
|&emsp;&emsp;name||string||
|&emsp;&emsp;price||number||
|&emsp;&emsp;status||integer(int32)||
|&emsp;&emsp;updateTime||string(date-time)||
|&emsp;&emsp;updateUser||integer(int64)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": [
		{
			"categoryId": 0,
			"code": "",
			"createTime": "",
			"createUser": 0,
			"description": "",
			"id": 0,
			"image": "",
			"isDeleted": 0,
			"name": "",
			"price": 0,
			"status": 0,
			"updateTime": "",
			"updateUser": 0
		}
	],
	"map": {},
	"msg": ""
}
```


## queryByPage


**接口地址**:`/setmeal/page`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|name|name|query|false|string||
|page|page|query|false|integer(int32)||
|pageSize|pageSize|query|false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«Page«SetmealDto»»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||Page«SetmealDto»|Page«SetmealDto»|
|&emsp;&emsp;countId||string||
|&emsp;&emsp;current||integer(int64)||
|&emsp;&emsp;maxLimit||integer(int64)||
|&emsp;&emsp;optimizeCountSql||boolean||
|&emsp;&emsp;orders||array|OrderItem|
|&emsp;&emsp;&emsp;&emsp;asc||boolean||
|&emsp;&emsp;&emsp;&emsp;column||string||
|&emsp;&emsp;pages||integer(int64)||
|&emsp;&emsp;records||array|SetmealDto|
|&emsp;&emsp;&emsp;&emsp;categoryId||integer||
|&emsp;&emsp;&emsp;&emsp;categoryName||string||
|&emsp;&emsp;&emsp;&emsp;code||string||
|&emsp;&emsp;&emsp;&emsp;createTime||string||
|&emsp;&emsp;&emsp;&emsp;createUser||integer||
|&emsp;&emsp;&emsp;&emsp;description||string||
|&emsp;&emsp;&emsp;&emsp;id||integer||
|&emsp;&emsp;&emsp;&emsp;image||string||
|&emsp;&emsp;&emsp;&emsp;isDeleted||integer||
|&emsp;&emsp;&emsp;&emsp;name||string||
|&emsp;&emsp;&emsp;&emsp;price||number||
|&emsp;&emsp;&emsp;&emsp;setmealDishes||array|SetmealDish|
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;copies||integer||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;createTime||string||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;createUser||integer||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;dishId||string||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;id||integer||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;isDeleted||integer||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;name||string||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;price||number||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;setmealId||string||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;sort||integer||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;updateTime||string||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;updateUser||integer||
|&emsp;&emsp;&emsp;&emsp;status||integer||
|&emsp;&emsp;&emsp;&emsp;updateTime||string||
|&emsp;&emsp;&emsp;&emsp;updateUser||integer||
|&emsp;&emsp;searchCount||boolean||
|&emsp;&emsp;size||integer(int64)||
|&emsp;&emsp;total||integer(int64)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"countId": "",
		"current": 0,
		"maxLimit": 0,
		"optimizeCountSql": true,
		"orders": [
			{
				"asc": true,
				"column": ""
			}
		],
		"pages": 0,
		"records": [
			{
				"categoryId": 0,
				"categoryName": "",
				"code": "",
				"createTime": "",
				"createUser": 0,
				"description": "",
				"id": 0,
				"image": "",
				"isDeleted": 0,
				"name": "",
				"price": 0,
				"setmealDishes": [
					{
						"copies": 0,
						"createTime": "",
						"createUser": 0,
						"dishId": "",
						"id": 0,
						"isDeleted": 0,
						"name": "",
						"price": 0,
						"setmealId": "",
						"sort": 0,
						"updateTime": "",
						"updateUser": 0
					}
				],
				"status": 0,
				"updateTime": "",
				"updateUser": 0
			}
		],
		"searchCount": true,
		"size": 0,
		"total": 0
	},
	"map": {},
	"msg": ""
}
```


## updateSetmealStatus


**接口地址**:`/setmeal/status/{status}`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|query|true|array|integer|
|status|status|path|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## queryById


**接口地址**:`/setmeal/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«SetmealDto»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||SetmealDto|SetmealDto|
|&emsp;&emsp;categoryId||integer(int64)||
|&emsp;&emsp;categoryName||string||
|&emsp;&emsp;code||string||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;createUser||integer(int64)||
|&emsp;&emsp;description||string||
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;image||string||
|&emsp;&emsp;isDeleted||integer(int32)||
|&emsp;&emsp;name||string||
|&emsp;&emsp;price||number||
|&emsp;&emsp;setmealDishes||array|SetmealDish|
|&emsp;&emsp;&emsp;&emsp;copies||integer||
|&emsp;&emsp;&emsp;&emsp;createTime||string||
|&emsp;&emsp;&emsp;&emsp;createUser||integer||
|&emsp;&emsp;&emsp;&emsp;dishId||string||
|&emsp;&emsp;&emsp;&emsp;id||integer||
|&emsp;&emsp;&emsp;&emsp;isDeleted||integer||
|&emsp;&emsp;&emsp;&emsp;name||string||
|&emsp;&emsp;&emsp;&emsp;price||number||
|&emsp;&emsp;&emsp;&emsp;setmealId||string||
|&emsp;&emsp;&emsp;&emsp;sort||integer||
|&emsp;&emsp;&emsp;&emsp;updateTime||string||
|&emsp;&emsp;&emsp;&emsp;updateUser||integer||
|&emsp;&emsp;status||integer(int32)||
|&emsp;&emsp;updateTime||string(date-time)||
|&emsp;&emsp;updateUser||integer(int64)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"categoryId": 0,
		"categoryName": "",
		"code": "",
		"createTime": "",
		"createUser": 0,
		"description": "",
		"id": 0,
		"image": "",
		"isDeleted": 0,
		"name": "",
		"price": 0,
		"setmealDishes": [
			{
				"copies": 0,
				"createTime": "",
				"createUser": 0,
				"dishId": "",
				"id": 0,
				"isDeleted": 0,
				"name": "",
				"price": 0,
				"setmealId": "",
				"sort": 0,
				"updateTime": "",
				"updateUser": 0
			}
		],
		"status": 0,
		"updateTime": "",
		"updateUser": 0
	},
	"map": {},
	"msg": ""
}
```


# shopping-cart-controller


## queryByPage


**接口地址**:`/shoppingCart`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|amount||query|false|number||
|createTime||query|false|string(date-time)||
|dishFlavor||query|false|string||
|dishId||query|false|integer(int64)||
|id||query|false|integer(int64)||
|image||query|false|string||
|name||query|false|string||
|number||query|false|integer(int32)||
|offset||query|false|integer(int64)||
|pageNumber||query|false|integer(int32)||
|pageSize||query|false|integer(int32)||
|setmealId||query|false|integer(int64)||
|sort.sorted||query|false|boolean||
|sort.unsorted||query|false|boolean||
|updateTime||query|false|string(date-time)||
|userId||query|false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|Page«ShoppingCart»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|countId||string||
|current||integer(int64)|integer(int64)|
|maxLimit||integer(int64)|integer(int64)|
|optimizeCountSql||boolean||
|orders||array|OrderItem|
|&emsp;&emsp;asc||boolean||
|&emsp;&emsp;column||string||
|pages||integer(int64)|integer(int64)|
|records||array|ShoppingCart|
|&emsp;&emsp;amount||number||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;dishFlavor||string||
|&emsp;&emsp;dishId||integer(int64)||
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;image||string||
|&emsp;&emsp;name||string||
|&emsp;&emsp;number||integer(int32)||
|&emsp;&emsp;setmealId||integer(int64)||
|&emsp;&emsp;updateTime||string(date-time)||
|&emsp;&emsp;userId||integer(int64)||
|searchCount||boolean||
|size||integer(int64)|integer(int64)|
|total||integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"countId": "",
	"current": 0,
	"maxLimit": 0,
	"optimizeCountSql": true,
	"orders": [
		{
			"asc": true,
			"column": ""
		}
	],
	"pages": 0,
	"records": [
		{
			"amount": 0,
			"createTime": "",
			"dishFlavor": "",
			"dishId": 0,
			"id": 0,
			"image": "",
			"name": "",
			"number": 0,
			"setmealId": 0,
			"updateTime": "",
			"userId": 0
		}
	],
	"searchCount": true,
	"size": 0,
	"total": 0
}
```


## edit


**接口地址**:`/shoppingCart`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "amount": 0,
  "createTime": "",
  "dishFlavor": "",
  "dishId": 0,
  "id": 0,
  "image": "",
  "name": "",
  "number": 0,
  "setmealId": 0,
  "updateTime": "",
  "userId": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|shoppingCart|shoppingCart|body|true|ShoppingCart|ShoppingCart|
|&emsp;&emsp;amount|||false|number||
|&emsp;&emsp;createTime|||false|string(date-time)||
|&emsp;&emsp;dishFlavor|||false|string||
|&emsp;&emsp;dishId|||false|integer(int64)||
|&emsp;&emsp;id|||false|integer(int64)||
|&emsp;&emsp;image|||false|string||
|&emsp;&emsp;name|||false|string||
|&emsp;&emsp;number|||false|integer(int32)||
|&emsp;&emsp;setmealId|||false|integer(int64)||
|&emsp;&emsp;updateTime|||false|string(date-time)||
|&emsp;&emsp;userId|||false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ShoppingCart|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|amount||number||
|createTime||string(date-time)|string(date-time)|
|dishFlavor||string||
|dishId||integer(int64)|integer(int64)|
|id||integer(int64)|integer(int64)|
|image||string||
|name||string||
|number||integer(int32)|integer(int32)|
|setmealId||integer(int64)|integer(int64)|
|updateTime||string(date-time)|string(date-time)|
|userId||integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"amount": 0,
	"createTime": "",
	"dishFlavor": "",
	"dishId": 0,
	"id": 0,
	"image": "",
	"name": "",
	"number": 0,
	"setmealId": 0,
	"updateTime": "",
	"userId": 0
}
```


## add


**接口地址**:`/shoppingCart/add`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "amount": 0,
  "createTime": "",
  "dishFlavor": "",
  "dishId": 0,
  "id": 0,
  "image": "",
  "name": "",
  "number": 0,
  "setmealId": 0,
  "updateTime": "",
  "userId": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|shoppingCart|shoppingCart|body|true|ShoppingCart|ShoppingCart|
|&emsp;&emsp;amount|||false|number||
|&emsp;&emsp;createTime|||false|string(date-time)||
|&emsp;&emsp;dishFlavor|||false|string||
|&emsp;&emsp;dishId|||false|integer(int64)||
|&emsp;&emsp;id|||false|integer(int64)||
|&emsp;&emsp;image|||false|string||
|&emsp;&emsp;name|||false|string||
|&emsp;&emsp;number|||false|integer(int32)||
|&emsp;&emsp;setmealId|||false|integer(int64)||
|&emsp;&emsp;updateTime|||false|string(date-time)||
|&emsp;&emsp;userId|||false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«ShoppingCart»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||ShoppingCart|ShoppingCart|
|&emsp;&emsp;amount||number||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;dishFlavor||string||
|&emsp;&emsp;dishId||integer(int64)||
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;image||string||
|&emsp;&emsp;name||string||
|&emsp;&emsp;number||integer(int32)||
|&emsp;&emsp;setmealId||integer(int64)||
|&emsp;&emsp;updateTime||string(date-time)||
|&emsp;&emsp;userId||integer(int64)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"amount": 0,
		"createTime": "",
		"dishFlavor": "",
		"dishId": 0,
		"id": 0,
		"image": "",
		"name": "",
		"number": 0,
		"setmealId": 0,
		"updateTime": "",
		"userId": 0
	},
	"map": {},
	"msg": ""
}
```


## deleteById


**接口地址**:`/shoppingCart/clean`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«string»|
|204|No Content||
|401|Unauthorized||
|403|Forbidden||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## list


**接口地址**:`/shoppingCart/list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«List«ShoppingCart»»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||array|ShoppingCart|
|&emsp;&emsp;amount||number||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;dishFlavor||string||
|&emsp;&emsp;dishId||integer(int64)||
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;image||string||
|&emsp;&emsp;name||string||
|&emsp;&emsp;number||integer(int32)||
|&emsp;&emsp;setmealId||integer(int64)||
|&emsp;&emsp;updateTime||string(date-time)||
|&emsp;&emsp;userId||integer(int64)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": [
		{
			"amount": 0,
			"createTime": "",
			"dishFlavor": "",
			"dishId": 0,
			"id": 0,
			"image": "",
			"name": "",
			"number": 0,
			"setmealId": 0,
			"updateTime": "",
			"userId": 0
		}
	],
	"map": {},
	"msg": ""
}
```


## sub


**接口地址**:`/shoppingCart/sub`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "amount": 0,
  "createTime": "",
  "dishFlavor": "",
  "dishId": 0,
  "id": 0,
  "image": "",
  "name": "",
  "number": 0,
  "setmealId": 0,
  "updateTime": "",
  "userId": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|shoppingCart|shoppingCart|body|true|ShoppingCart|ShoppingCart|
|&emsp;&emsp;amount|||false|number||
|&emsp;&emsp;createTime|||false|string(date-time)||
|&emsp;&emsp;dishFlavor|||false|string||
|&emsp;&emsp;dishId|||false|integer(int64)||
|&emsp;&emsp;id|||false|integer(int64)||
|&emsp;&emsp;image|||false|string||
|&emsp;&emsp;name|||false|string||
|&emsp;&emsp;number|||false|integer(int32)||
|&emsp;&emsp;setmealId|||false|integer(int64)||
|&emsp;&emsp;updateTime|||false|string(date-time)||
|&emsp;&emsp;userId|||false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## queryById


**接口地址**:`/shoppingCart/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ShoppingCart|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|amount||number||
|createTime||string(date-time)|string(date-time)|
|dishFlavor||string||
|dishId||integer(int64)|integer(int64)|
|id||integer(int64)|integer(int64)|
|image||string||
|name||string||
|number||integer(int32)|integer(int32)|
|setmealId||integer(int64)|integer(int64)|
|updateTime||string(date-time)|string(date-time)|
|userId||integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"amount": 0,
	"createTime": "",
	"dishFlavor": "",
	"dishId": 0,
	"id": 0,
	"image": "",
	"name": "",
	"number": 0,
	"setmealId": 0,
	"updateTime": "",
	"userId": 0
}
```


# 用户信息(User)表控制层


## 分页查询


**接口地址**:`/user`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>分页查询</p>



**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|avatar||query|false|string||
|id||query|false|integer(int64)||
|idNumber||query|false|string||
|name||query|false|string||
|offset||query|false|integer(int64)||
|pageNumber||query|false|integer(int32)||
|pageRequest|分页对象|query|false|||
|pageSize||query|false|integer(int32)||
|phone||query|false|string||
|sex||query|false|string||
|sort.sorted||query|false|boolean||
|sort.unsorted||query|false|boolean||
|status||query|false|integer(int32)||
|user|筛选条件|query|false|||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|Page«User»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|countId||string||
|current||integer(int64)|integer(int64)|
|maxLimit||integer(int64)|integer(int64)|
|optimizeCountSql||boolean||
|orders||array|OrderItem|
|&emsp;&emsp;asc||boolean||
|&emsp;&emsp;column||string||
|pages||integer(int64)|integer(int64)|
|records||array|User|
|&emsp;&emsp;avatar||string||
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;idNumber||string||
|&emsp;&emsp;name||string||
|&emsp;&emsp;phone||string||
|&emsp;&emsp;sex||string||
|&emsp;&emsp;status||integer(int32)||
|searchCount||boolean||
|size||integer(int64)|integer(int64)|
|total||integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"countId": "",
	"current": 0,
	"maxLimit": 0,
	"optimizeCountSql": true,
	"orders": [
		{
			"asc": true,
			"column": ""
		}
	],
	"pages": 0,
	"records": [
		{
			"avatar": "",
			"id": 0,
			"idNumber": "",
			"name": "",
			"phone": "",
			"sex": "",
			"status": 0
		}
	],
	"searchCount": true,
	"size": 0,
	"total": 0
}
```


## 新增数据


**接口地址**:`/user`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:<p>新增数据</p>



**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|user|实体|body|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|User|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|avatar||string||
|id||integer(int64)|integer(int64)|
|idNumber||string||
|name||string||
|phone||string||
|sex||string||
|status||integer(int32)|integer(int32)|


**响应示例**:
```javascript
{
	"avatar": "",
	"id": 0,
	"idNumber": "",
	"name": "",
	"phone": "",
	"sex": "",
	"status": 0
}
```


## 编辑数据


**接口地址**:`/user`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:<p>编辑数据</p>



**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|user|实体|body|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|User|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|avatar||string||
|id||integer(int64)|integer(int64)|
|idNumber||string||
|name||string||
|phone||string||
|sex||string||
|status||integer(int32)|integer(int32)|


**响应示例**:
```javascript
{
	"avatar": "",
	"id": 0,
	"idNumber": "",
	"name": "",
	"phone": "",
	"sex": "",
	"status": 0
}
```


## 删除数据


**接口地址**:`/user`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>删除数据</p>



**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|主键|query|false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK||
|204|No Content||
|401|Unauthorized||
|403|Forbidden||


**响应参数**:


暂无


**响应示例**:
```javascript

```


## 移动端用户登录   phone变量的字符串值是邮箱，对应的在session的value是验证码 这里的接收参数是phone和code,一般肯定单独创建一个dto来接收,这里直接其实使用map也可以


**接口地址**:`/user/login`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:<p>移动端用户登录   phone变量的字符串值是邮箱，对应的在session的value是验证码 这里的接收参数是phone和code,一般肯定单独创建一个dto来接收,这里直接其实使用map也可以</p>



**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|map|map|body|true|string||
|creationTime||query|false|integer(int64)||
|id||query|false|string||
|lastAccessedTime||query|false|integer(int64)||
|maxInactiveInterval||query|false|integer(int32)||
|new||query|false|boolean||
|session||query|false|||
|valueNames||query|false|array|string|


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«User»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||User|User|
|&emsp;&emsp;avatar||string||
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;idNumber||string||
|&emsp;&emsp;name||string||
|&emsp;&emsp;phone||string||
|&emsp;&emsp;sex||string||
|&emsp;&emsp;status||integer(int32)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"avatar": "",
		"id": 0,
		"idNumber": "",
		"name": "",
		"phone": "",
		"sex": "",
		"status": 0
	},
	"map": {},
	"msg": ""
}
```


## logout


**接口地址**:`/user/logout`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:<p>logout</p>



**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|request||query|false|||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## 发送qq邮箱验证码短信


**接口地址**:`/user/sendMsg`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:<p>发送qq邮箱验证码短信</p>



**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|user|user|body|true|string||
|creationTime||query|false|integer(int64)||
|id||query|false|string||
|lastAccessedTime||query|false|integer(int64)||
|maxInactiveInterval||query|false|integer(int32)||
|new||query|false|boolean||
|session||query|false|||
|valueNames||query|false|array|string|


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## 通过主键查询单条数据


**接口地址**:`/user/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>通过主键查询单条数据</p>



**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|主键|path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|User|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|avatar||string||
|id||integer(int64)|integer(int64)|
|idNumber||string||
|name||string||
|phone||string||
|sex||string||
|status||integer(int32)|integer(int32)|


**响应示例**:
```javascript
{
	"avatar": "",
	"id": 0,
	"idNumber": "",
	"name": "",
	"phone": "",
	"sex": "",
	"status": 0
}
```


# 菜品管理(Dish)表控制层


## 新增数据


**接口地址**:`/dish`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:<p>新增数据</p>



**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|dishDto|实体|body|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## 编辑数据


**接口地址**:`/dish`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:<p>编辑数据</p>



**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|dishDto|实体|body|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## 删除数据


**接口地址**:`/dish`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>删除数据</p>



**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|主键|query|true|array|integer|


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«string»|
|204|No Content||
|401|Unauthorized||
|403|Forbidden||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## 通过categoryId查询dish集合


**接口地址**:`/dish/list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>通过categoryId查询dish集合</p>



**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|categoryId||query|false|integer(int64)||
|code||query|false|string||
|createTime||query|false|string(date-time)||
|createUser||query|false|integer(int64)||
|description||query|false|string||
|dish|封装前端传过来的categoryId数据|query|false|||
|id||query|false|integer(int64)||
|image||query|false|string||
|isDeleted||query|false|integer(int32)||
|name||query|false|string||
|price||query|false|number||
|sort||query|false|integer(int32)||
|status||query|false|integer(int32)||
|updateTime||query|false|string(date-time)||
|updateUser||query|false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«List«DishDto»»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||array|DishDto|
|&emsp;&emsp;categoryId||integer(int64)||
|&emsp;&emsp;categoryName||string||
|&emsp;&emsp;code||string||
|&emsp;&emsp;copies||integer(int32)||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;createUser||integer(int64)||
|&emsp;&emsp;description||string||
|&emsp;&emsp;flavors||array|DishFlavor|
|&emsp;&emsp;&emsp;&emsp;createTime||string||
|&emsp;&emsp;&emsp;&emsp;createUser||integer||
|&emsp;&emsp;&emsp;&emsp;dishId||integer||
|&emsp;&emsp;&emsp;&emsp;id||integer||
|&emsp;&emsp;&emsp;&emsp;isDeleted||integer||
|&emsp;&emsp;&emsp;&emsp;name||string||
|&emsp;&emsp;&emsp;&emsp;updateTime||string||
|&emsp;&emsp;&emsp;&emsp;updateUser||integer||
|&emsp;&emsp;&emsp;&emsp;value||string||
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;image||string||
|&emsp;&emsp;isDeleted||integer(int32)||
|&emsp;&emsp;name||string||
|&emsp;&emsp;price||number||
|&emsp;&emsp;sort||integer(int32)||
|&emsp;&emsp;status||integer(int32)||
|&emsp;&emsp;updateTime||string(date-time)||
|&emsp;&emsp;updateUser||integer(int64)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": [
		{
			"categoryId": 0,
			"categoryName": "",
			"code": "",
			"copies": 0,
			"createTime": "",
			"createUser": 0,
			"description": "",
			"flavors": [
				{
					"createTime": "",
					"createUser": 0,
					"dishId": 0,
					"id": 0,
					"isDeleted": 0,
					"name": "",
					"updateTime": "",
					"updateUser": 0,
					"value": ""
				}
			],
			"id": 0,
			"image": "",
			"isDeleted": 0,
			"name": "",
			"price": 0,
			"sort": 0,
			"status": 0,
			"updateTime": "",
			"updateUser": 0
		}
	],
	"map": {},
	"msg": ""
}
```


## 分页查询


**接口地址**:`/dish/page`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>分页查询</p>



**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|name|搜索条件|query|false|string||
|page|分页对象|query|false|integer(int32)||
|pageSize|页面大小|query|false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«Page«DishDto»»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||Page«DishDto»|Page«DishDto»|
|&emsp;&emsp;countId||string||
|&emsp;&emsp;current||integer(int64)||
|&emsp;&emsp;maxLimit||integer(int64)||
|&emsp;&emsp;optimizeCountSql||boolean||
|&emsp;&emsp;orders||array|OrderItem|
|&emsp;&emsp;&emsp;&emsp;asc||boolean||
|&emsp;&emsp;&emsp;&emsp;column||string||
|&emsp;&emsp;pages||integer(int64)||
|&emsp;&emsp;records||array|DishDto|
|&emsp;&emsp;&emsp;&emsp;categoryId||integer||
|&emsp;&emsp;&emsp;&emsp;categoryName||string||
|&emsp;&emsp;&emsp;&emsp;code||string||
|&emsp;&emsp;&emsp;&emsp;copies||integer||
|&emsp;&emsp;&emsp;&emsp;createTime||string||
|&emsp;&emsp;&emsp;&emsp;createUser||integer||
|&emsp;&emsp;&emsp;&emsp;description||string||
|&emsp;&emsp;&emsp;&emsp;flavors||array|DishFlavor|
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;createTime||string||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;createUser||integer||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;dishId||integer||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;id||integer||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;isDeleted||integer||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;name||string||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;updateTime||string||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;updateUser||integer||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;value||string||
|&emsp;&emsp;&emsp;&emsp;id||integer||
|&emsp;&emsp;&emsp;&emsp;image||string||
|&emsp;&emsp;&emsp;&emsp;isDeleted||integer||
|&emsp;&emsp;&emsp;&emsp;name||string||
|&emsp;&emsp;&emsp;&emsp;price||number||
|&emsp;&emsp;&emsp;&emsp;sort||integer||
|&emsp;&emsp;&emsp;&emsp;status||integer||
|&emsp;&emsp;&emsp;&emsp;updateTime||string||
|&emsp;&emsp;&emsp;&emsp;updateUser||integer||
|&emsp;&emsp;searchCount||boolean||
|&emsp;&emsp;size||integer(int64)||
|&emsp;&emsp;total||integer(int64)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"countId": "",
		"current": 0,
		"maxLimit": 0,
		"optimizeCountSql": true,
		"orders": [
			{
				"asc": true,
				"column": ""
			}
		],
		"pages": 0,
		"records": [
			{
				"categoryId": 0,
				"categoryName": "",
				"code": "",
				"copies": 0,
				"createTime": "",
				"createUser": 0,
				"description": "",
				"flavors": [
					{
						"createTime": "",
						"createUser": 0,
						"dishId": 0,
						"id": 0,
						"isDeleted": 0,
						"name": "",
						"updateTime": "",
						"updateUser": 0,
						"value": ""
					}
				],
				"id": 0,
				"image": "",
				"isDeleted": 0,
				"name": "",
				"price": 0,
				"sort": 0,
				"status": 0,
				"updateTime": "",
				"updateUser": 0
			}
		],
		"searchCount": true,
		"size": 0,
		"total": 0
	},
	"map": {},
	"msg": ""
}
```


## updateSaleStatus


**接口地址**:`/dish/status/{status}`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|query|true|array|integer|
|status|status|path|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## 通过主键查询单条数据


**接口地址**:`/dish/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>通过主键查询单条数据</p>



**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|主键|path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|R«DishDto»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||DishDto|DishDto|
|&emsp;&emsp;categoryId||integer(int64)||
|&emsp;&emsp;categoryName||string||
|&emsp;&emsp;code||string||
|&emsp;&emsp;copies||integer(int32)||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;createUser||integer(int64)||
|&emsp;&emsp;description||string||
|&emsp;&emsp;flavors||array|DishFlavor|
|&emsp;&emsp;&emsp;&emsp;createTime||string||
|&emsp;&emsp;&emsp;&emsp;createUser||integer||
|&emsp;&emsp;&emsp;&emsp;dishId||integer||
|&emsp;&emsp;&emsp;&emsp;id||integer||
|&emsp;&emsp;&emsp;&emsp;isDeleted||integer||
|&emsp;&emsp;&emsp;&emsp;name||string||
|&emsp;&emsp;&emsp;&emsp;updateTime||string||
|&emsp;&emsp;&emsp;&emsp;updateUser||integer||
|&emsp;&emsp;&emsp;&emsp;value||string||
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;image||string||
|&emsp;&emsp;isDeleted||integer(int32)||
|&emsp;&emsp;name||string||
|&emsp;&emsp;price||number||
|&emsp;&emsp;sort||integer(int32)||
|&emsp;&emsp;status||integer(int32)||
|&emsp;&emsp;updateTime||string(date-time)||
|&emsp;&emsp;updateUser||integer(int64)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"categoryId": 0,
		"categoryName": "",
		"code": "",
		"copies": 0,
		"createTime": "",
		"createUser": 0,
		"description": "",
		"flavors": [
			{
				"createTime": "",
				"createUser": 0,
				"dishId": 0,
				"id": 0,
				"isDeleted": 0,
				"name": "",
				"updateTime": "",
				"updateUser": 0,
				"value": ""
			}
		],
		"id": 0,
		"image": "",
		"isDeleted": 0,
		"name": "",
		"price": 0,
		"sort": 0,
		"status": 0,
		"updateTime": "",
		"updateUser": 0
	},
	"map": {},
	"msg": ""
}
```