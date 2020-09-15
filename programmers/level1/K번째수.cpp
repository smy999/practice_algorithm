{\rtf1\ansi\ansicpg949\cocoartf2513
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww7700\viewh18000\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs36 \cf0 // https://programmers.co.kr/learn/courses/30/lessons/42748\
\
#include <vector>\
#include <algorithm>\
\
using namespace std;\
\
vector<int> solution(vector<int> array, vector<vector<int>> commands) \{\
    vector<int> answer;\
    vector<int> temp;\
    \
    for(int i=0;i<commands.size();i++)\{\
        temp = array;\
        sort(temp.begin()+ commands[i][0]-1, temp.begin() + commands[i][1]);\
        answer.push_back(temp[commands[i][0] + commands[i][2] -2]);\
    \}\
    \
    return answer;\
\}}