#!/bin/bash

# 定义API基础URL
BASE_URL="http://localhost:8081/api/users"

echo "--- 用户API测试脚本 ---"
echo

# 1. 创建用户
echo "1. 创建用户..."
curl -X POST "$BASE_URL" \
  -H "Content-Type: application/json" \
  -d '{
    "username": "user1",
    "password": "123456",
    "nickname": "测试用户001",
    "email": "user1@example.com",
    "phone": "18800000001"
  }'
echo -e "\n"

# 2. 根据ID获取用户
echo "2. 根据ID获取用户 (ID: 1)..."
curl -X GET "$BASE_URL/1"
echo -e "\n"

# 3. 获取所有用户
echo "3. 获取所有用户..."
curl -X GET "$BASE_URL"
echo -e "\n"

# 4. 分页查询用户
echo "4. 分页查询用户 (当前页: 1, 每页大小: 5)..."
curl -X GET "$BASE_URL/page?current=1&size=5"
echo -e "\n"

# 5. 根据用户名查询
echo "5. 根据用户名查询 (用户名: user1)..."
curl -X GET "$BASE_URL/username/user1"
echo -e "\n"

# 6. 根据邮箱查询
echo "6. 根据邮箱查询 (邮箱: user1@example.com)..."
curl -X GET "$BASE_URL/email/user1@example.com"
echo -e "\n"

# 7. 根据状态查询
echo "7. 根据状态查询 (状态: 1)..."
curl -X GET "$BASE_URL/status/1"
echo -e "\n"

# 8. 模糊查询昵称
echo "8. 模糊查询昵称 (昵称包含: 001)..."
curl -X GET "$BASE_URL/search?nickname=001"
echo -e "\n"

# 9. 更新用户
echo "9. 更新用户 (ID: 1)..."
curl -X PUT "$BASE_URL/1" \
  -H "Content-Type: application/json" \
  -d '{
    "username": "user1",
    "password": "123456",
    "nickname": "测试用户1-修改",
    "email": "user1@example.com",
    "phone": "18800000001"
  }'
echo -e "\n"

# 10. 删除用户
echo "10. 删除用户 (ID: 1)..."
curl -X DELETE "$BASE_URL/1"
echo -e "\n"

# 11. 批量创建用户
echo "11. 批量创建用户..."
curl -X POST "$BASE_URL/batch" \
  -H "Content-Type: application/json" \
  -d '[
    {
      "username": "user2",
      "password": "123456",
      "nickname": "测试用户2",
      "email": "user2@example.com",
      "phone": "18800000002"
    },
    {
      "username": "user3",
      "password": "123456",
      "nickname": "测试用户3",
      "email": "user3@example.com",
      "phone": "18800000003"
    }
  ]'
echo -e "\n"

# 12. 批量删除用户
echo "12. 批量删除用户 (IDs: 2, 3)..."
curl -X DELETE "$BASE_URL/batch" \
  -H "Content-Type: application/json" \
  -d '[2,3]'
echo -e "\n"

# 13. 获取用户总数
echo "13. 获取用户总数..."
curl -X GET "$BASE_URL/count"
echo -e "\n"

# 14. 获取活跃用户数
echo "14. 获取活跃用户数..."
curl -X GET "$BASE_URL/count/active"
echo -e "\n"

# 15. 更新用户状态
echo "15. 更新用户状态 (ID: 1, 状态: 0)..."
curl -X PATCH "$BASE_URL/1/status?status=0"
echo -e "\n"

echo "--- 测试脚本执行完毕 ---"