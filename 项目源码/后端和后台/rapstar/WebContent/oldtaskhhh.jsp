<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ctx }/layui/css/layui.css">
</head>
<body layadmin-themealias="default">
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
      <div class="layui-col-md8">
        <div class="layui-row layui-col-space15">
          <div class="layui-col-md6">
            <div class="layui-card">
              <div class="layui-card-header">快捷方式</div>
              <div class="layui-card-body">
                
                <div class="layui-carousel layadmin-carousel layadmin-shortcut" lay-anim="" lay-indicator="inside" lay-arrow="none" style="width: 100%; height: 280px;">
                  <div carousel-item="">
                    <ul class="layui-row layui-col-space10 layui-this">
                      <li class="layui-col-xs3">
                        <a lay-href="home/homepage1.html">
                          <i class="layui-icon layui-icon-console"></i>
                          <cite>主页一</cite>
                        </a>
                      </li>
                      <li class="layui-col-xs3">
                        <a lay-href="home/homepage2.html">
                          <i class="layui-icon layui-icon-chart"></i>
                          <cite>主页二</cite>
                        </a>
                      </li>
                      <li class="layui-col-xs3">
                        <a lay-href="component/layer/list.html">
                          <i class="layui-icon layui-icon-template-1"></i>
                          <cite>弹层</cite>
                        </a>
                      </li>
                      <li class="layui-col-xs3">
                        <a lay-href="senior/im/">
                          <i class="layui-icon layui-icon-chat"></i>
                          <cite>聊天</cite>
                        </a>
                      </li>
                      <li class="layui-col-xs3">
                        <a lay-href="component/progress/index.html">
                          <i class="layui-icon layui-icon-find-fill"></i>
                          <cite>进度条</cite>
                        </a>
                      </li>
                      <li class="layui-col-xs3">
                        <a lay-href="app/workorder/list.html">
                          <i class="layui-icon layui-icon-survey"></i>
                          <cite>工单</cite>
                        </a>
                      </li>
                      <li class="layui-col-xs3">
                        <a lay-href="user/user/list.html">
                          <i class="layui-icon layui-icon-user"></i>
                          <cite>用户</cite>
                        </a>
                      </li>
                      <li class="layui-col-xs3">
                        <a lay-href="set/system/website.html">
                          <i class="layui-icon layui-icon-set"></i>
                          <cite>设置</cite>
                        </a>
                      </li>
                    </ul>
                    <ul class="layui-row layui-col-space10">
                      <li class="layui-col-xs3">
                        <a lay-href="set/user/info.html">
                          <i class="layui-icon layui-icon-set"></i>
                          <cite>我的资料</cite>
                        </a>
                      </li>
                      <li class="layui-col-xs3">
                        <a lay-href="set/user/info.html">
                          <i class="layui-icon layui-icon-set"></i>
                          <cite>我的资料</cite>
                        </a>
                      </li>
                      <li class="layui-col-xs3">
                        <a lay-href="set/user/info.html">
                          <i class="layui-icon layui-icon-set"></i>
                          <cite>我的资料</cite>
                        </a>
                      </li>
                      <li class="layui-col-xs3">
                        <a lay-href="set/user/info.html">
                          <i class="layui-icon layui-icon-set"></i>
                          <cite>我的资料</cite>
                        </a>
                      </li>
                      <li class="layui-col-xs3">
                        <a lay-href="set/user/info.html">
                          <i class="layui-icon layui-icon-set"></i>
                          <cite>我的资料</cite>
                        </a>
                      </li>
                      <li class="layui-col-xs3">
                        <a lay-href="set/user/info.html">
                          <i class="layui-icon layui-icon-set"></i>
                          <cite>我的资料</cite>
                        </a>
                      </li>
                      <li class="layui-col-xs3">
                        <a lay-href="set/user/info.html">
                          <i class="layui-icon layui-icon-set"></i>
                          <cite>我的资料</cite>
                        </a>
                      </li>
                      <li class="layui-col-xs3">
                        <a lay-href="set/user/info.html">
                          <i class="layui-icon layui-icon-set"></i>
                          <cite>我的资料</cite>
                        </a>
                      </li>
                    </ul>
                    
                  </div>
                <div class="layui-carousel-ind"><ul><li class="layui-this"></li><li></li></ul></div><button class="layui-icon layui-carousel-arrow" lay-type="sub"></button><button class="layui-icon layui-carousel-arrow" lay-type="add"></button></div>
                
              </div>
            </div>
          </div>
          <div class="layui-col-md6">
            <div class="layui-card">
              <div class="layui-card-header">待办事项</div>
              <div class="layui-card-body">

                <div class="layui-carousel layadmin-carousel layadmin-backlog" lay-anim="" lay-indicator="inside" lay-arrow="none" style="width: 100%; height: 280px;">
                  <div carousel-item="">
                    <ul class="layui-row layui-col-space10 layui-this">
                      <li class="layui-col-xs6">
                        <a lay-href="app/content/comment.html" class="layadmin-backlog-body">
                          <h3>待审评论</h3>
                          <p><cite>66</cite></p>
                        </a>
                      </li>
                      <li class="layui-col-xs6">
                        <a lay-href="app/forum/list.html" class="layadmin-backlog-body">
                          <h3>待审帖子</h3>
                          <p><cite>12</cite></p>
                        </a>
                      </li>
                      <li class="layui-col-xs6">
                        <a lay-href="template/goodslist.html" class="layadmin-backlog-body">
                          <h3>待审商品</h3>
                          <p><cite>99</cite></p>
                        </a>
                      </li>
                      <li class="layui-col-xs6">
                        <a href="javascript:;" onclick="layer.tips('不跳转', this, {tips: 3});" class="layadmin-backlog-body">
                          <h3>待发货</h3>
                          <p><cite>20</cite></p>
                        </a>
                      </li>
                    </ul>
                    <ul class="layui-row layui-col-space10">
                      <li class="layui-col-xs6">
                        <a href="javascript:;" class="layadmin-backlog-body">
                          <h3>待审友情链接</h3>
                          <p><cite style="color: #FF5722;">5</cite></p>
                        </a>
                      </li>
                    </ul>
                  </div>
                <div class="layui-carousel-ind"><ul><li class="layui-this"></li><li></li></ul></div><button class="layui-icon layui-carousel-arrow" lay-type="sub"></button><button class="layui-icon layui-carousel-arrow" lay-type="add"></button></div>
              </div>
            </div>
          </div>
          <div class="layui-col-md12">
            <div class="layui-card">
              <div class="layui-card-header">数据概览</div>
              <div class="layui-card-body">
                
                <div class="layui-carousel layadmin-carousel layadmin-dataview" data-anim="fade" lay-filter="LAY-index-dataview" lay-anim="fade" lay-indicator="inside" lay-arrow="none" style="width: 100%; height: 280px;">
                  <div carousel-item="" id="LAY-index-dataview">
                    <div class="layui-this" _echarts_instance_="1623025569610" style="-webkit-tap-highlight-color: transparent; user-select: none; cursor: default; background-color: rgba(0, 0, 0, 0);">
                    <div style="position: relative; overflow: hidden; width: 366px; height: 332px;">
                    <div data-zr-dom-id="bg" class="zr-element" style="position: absolute; left: 0px; top: 0px; width: 366px; height: 332px; user-select: none;"></div>
                    <canvas width="366" height="332" data-zr-dom-id="0" class="zr-element" style="position: absolute; left: 0px; top: 0px; width: 366px; height: 332px; user-select: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></canvas>
                    <canvas width="366" height="332" data-zr-dom-id="1" class="zr-element" style="position: absolute; left: 0px; top: 0px; width: 366px; height: 332px; user-select: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></canvas>
                    <canvas width="366" height="332" data-zr-dom-id="_zrender_hover_" class="zr-element" style="position: absolute; left: 0px; top: 0px; width: 366px; height: 332px; user-select: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></canvas>
                    <div class="echarts-tooltip zr-element" style="position: absolute; display: block; border-style: solid; white-space: nowrap; transition: left 0.4s ease 0s, top 0.4s ease 0s; background-color: rgba(50, 50, 50, 0.5); border-width: 0px; border-color: rgb(51, 51, 51); border-radius: 4px; color: rgb(255, 255, 255); font-family: 微软雅黑, Arial, Verdana, sans-serif; padding: 5px; left: 284px; top: 245px;">22:30<br>PV : 999<br>UV : 99</div></div></div>
                    <!--<div></div>-->
                    <div></div>
                  </div>
                <div class="layui-carousel-ind"><ul><li class="layui-this"></li><li></li></ul></div><button class="layui-icon layui-carousel-arrow" lay-type="sub"></button><button class="layui-icon layui-carousel-arrow" lay-type="add"></button></div>
                
              </div>
            </div>

            <div class="layui-card">
              <div class="layui-card-header">用户全国分布</div>
              <div class="layui-card-body">
                <div class="layui-row layui-col-space15">
                  <div class="layui-col-sm4">
                    <table class="layui-table layuiadmin-page-table" lay-skin="line">
                        <thead>
                          <tr>
                            <th>排名</th>
                            <th>地区</th>
                            <th>人数</th>
                          </tr> 
                        </thead>
                        <tbody>
                          <tr>
                            <td>1</td>
                            <td>浙江</td>
                            <td>62310</td>
                          </tr>
                          <tr>
                            <td>2</td>
                            <td>上海</td>
                            <td>59190</td>
                          </tr>
                          <tr>
                            <td>3</td>
                            <td>广东</td>
                            <td>55891</td>
                          </tr>
                          <tr>
                            <td>4</td>
                            <td>北京</td>
                            <td>51919</td>
                          </tr>  
                          <tr>
                            <td>5</td>
                            <td>山东</td>
                            <td>39231</td>
                          </tr>
                          <tr>
                            <td>6</td>
                            <td>湖北</td>
                            <td>37109</td>
                          </tr>
                        </tbody>
                      </table>
                  </div>
                  <div class="layui-col-sm8">
                    <div class="layui-carousel layadmin-carousel layadmin-dataview" data-anim="fade" lay-filter="LAY-index-pagethree-home" lay-anim="fade" style="width: 100%; height: 280px;">
                      <div carousel-item="" id="LAY-index-pagethree-home">
                        <div class="layui-this" _echarts_instance_="1623025569611" style="-webkit-tap-highlight-color: transparent; user-select: none; background-color: rgba(0, 0, 0, 0);"><div style="position: relative; overflow: hidden; width: 366px; height: 332px;"><div data-zr-dom-id="bg" class="zr-element" style="position: absolute; left: 0px; top: 0px; width: 460px; height: 332px; user-select: none;"></div><canvas width="366" height="332" data-zr-dom-id="0" class="zr-element" style="position: absolute; left: 0px; top: 0px; width: 366px; height: 332px; user-select: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></canvas><canvas width="366" height="332" data-zr-dom-id="1" class="zr-element" style="position: absolute; left: 0px; top: 0px; width: 366px; height: 332px; user-select: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></canvas><canvas width="366" height="332" data-zr-dom-id="_zrender_hover_" class="zr-element" style="position: absolute; left: 0px; top: 0px; width: 366px; height: 332px; user-select: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></canvas></div></div>
                      </div>
                    </div>    
                  </div>
                </div>
              </div>
            </div>

            <div class="layui-card">
              <div class="layui-tab layui-tab-brief layadmin-latestData">
                <ul class="layui-tab-title">
                  <li class="layui-this">今日热搜</li>
                  <li>今日热帖</li>
                </ul>
                <div class="layui-tab-content">
                  <div class="layui-tab-item layui-show">
                    <table id="LAY-index-topSearch"></table><div class="layui-form layui-border-box layui-table-view" lay-filter="LAY-table-1" lay-id="LAY-index-topSearch" style=" "><div class="layui-table-box"><div class="layui-table-header"><table cellspacing="0" cellpadding="0" border="0" class="layui-table" lay-skin="line"><thead><tr><th data-field="0" data-key="1-0-0" data-unresize="true" class=" layui-table-col-special"><div class="layui-table-cell laytable-cell-1-0-0 laytable-cell-numbers"><span></span></div></th><th data-field="keywords" data-key="1-0-1" data-minwidth="300" class=""><div class="layui-table-cell laytable-cell-1-0-1"><span>关键词</span></div></th><th data-field="frequency" data-key="1-0-2" data-minwidth="120" class=" layui-unselect"><div class="layui-table-cell laytable-cell-1-0-2"><span>搜索次数</span><span class="layui-table-sort layui-inline"><i class="layui-edge layui-table-sort-asc" title="升序"></i><i class="layui-edge layui-table-sort-desc" title="降序"></i></span></div></th><th data-field="userNums" data-key="1-0-3" class=" layui-unselect"><div class="layui-table-cell laytable-cell-1-0-3"><span>用户数</span><span class="layui-table-sort layui-inline"><i class="layui-edge layui-table-sort-asc" title="升序"></i><i class="layui-edge layui-table-sort-desc" title="降序"></i></span></div></th></tr></thead></table></div><div class="layui-table-body layui-table-main"><table cellspacing="0" cellpadding="0" border="0" class="layui-table" lay-skin="line"><tbody><tr data-index="0"><td data-field="0" data-key="1-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-1-0-0 laytable-cell-numbers">1</div></td><td data-field="keywords" data-key="1-0-1" data-content="layui" data-minwidth="300" class=""><div class="layui-table-cell laytable-cell-1-0-1"><a href="https://www.baidu.com/s?wd=layui" target="_blank" class="layui-table-link">layui</a></div></td><td data-field="frequency" data-key="1-0-2" data-minwidth="120" class=""><div class="layui-table-cell laytable-cell-1-0-2">8520</div></td><td data-field="userNums" data-key="1-0-3" class=""><div class="layui-table-cell laytable-cell-1-0-3">2216</div></td></tr><tr data-index="1"><td data-field="0" data-key="1-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-1-0-0 laytable-cell-numbers">2</div></td><td data-field="keywords" data-key="1-0-1" data-content="layer 弹出层组件" data-minwidth="300" class=""><div class="layui-table-cell laytable-cell-1-0-1"><a href="https://www.baidu.com/s?wd=layer 弹出层组件" target="_blank" class="layui-table-link">layer 弹出层组件</a></div></td><td data-field="frequency" data-key="1-0-2" data-minwidth="120" class=""><div class="layui-table-cell laytable-cell-1-0-2">666</div></td><td data-field="userNums" data-key="1-0-3" class=""><div class="layui-table-cell laytable-cell-1-0-3">333</div></td></tr><tr data-index="2"><td data-field="0" data-key="1-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-1-0-0 laytable-cell-numbers">3</div></td><td data-field="keywords" data-key="1-0-1" data-content="此表格是静态模拟数据" data-minwidth="300" class=""><div class="layui-table-cell laytable-cell-1-0-1"><a href="https://www.baidu.com/s?wd=此表格是静态模拟数据" target="_blank" class="layui-table-link">此表格是静态模拟数据</a></div></td><td data-field="frequency" data-key="1-0-2" data-minwidth="120" class=""><div class="layui-table-cell laytable-cell-1-0-2">666</div></td><td data-field="userNums" data-key="1-0-3" class=""><div class="layui-table-cell laytable-cell-1-0-3">333</div></td></tr><tr data-index="3"><td data-field="0" data-key="1-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-1-0-0 laytable-cell-numbers">4</div></td><td data-field="keywords" data-key="1-0-1" data-content="layui 文档" data-minwidth="300" class=""><div class="layui-table-cell laytable-cell-1-0-1"><a href="https://www.baidu.com/s?wd=layui 文档" target="_blank" class="layui-table-link">layui 文档</a></div></td><td data-field="frequency" data-key="1-0-2" data-minwidth="120" class=""><div class="layui-table-cell laytable-cell-1-0-2">666</div></td><td data-field="userNums" data-key="1-0-3" class=""><div class="layui-table-cell laytable-cell-1-0-3">333</div></td></tr><tr data-index="4"><td data-field="0" data-key="1-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-1-0-0 laytable-cell-numbers">5</div></td><td data-field="keywords" data-key="1-0-1" data-content="layui 文档" data-minwidth="300" class=""><div class="layui-table-cell laytable-cell-1-0-1"><a href="https://www.baidu.com/s?wd=layui 文档" target="_blank" class="layui-table-link">layui 文档</a></div></td><td data-field="frequency" data-key="1-0-2" data-minwidth="120" class=""><div class="layui-table-cell laytable-cell-1-0-2">666</div></td><td data-field="userNums" data-key="1-0-3" class=""><div class="layui-table-cell laytable-cell-1-0-3">333</div></td></tr><tr data-index="5"><td data-field="0" data-key="1-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-1-0-0 laytable-cell-numbers">6</div></td><td data-field="keywords" data-key="1-0-1" data-content="layui 文档" data-minwidth="300" class=""><div class="layui-table-cell laytable-cell-1-0-1"><a href="https://www.baidu.com/s?wd=layui 文档" target="_blank" class="layui-table-link">layui 文档</a></div></td><td data-field="frequency" data-key="1-0-2" data-minwidth="120" class=""><div class="layui-table-cell laytable-cell-1-0-2">666</div></td><td data-field="userNums" data-key="1-0-3" class=""><div class="layui-table-cell laytable-cell-1-0-3">333</div></td></tr><tr data-index="6"><td data-field="0" data-key="1-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-1-0-0 laytable-cell-numbers">7</div></td><td data-field="keywords" data-key="1-0-1" data-content="layui 文档" data-minwidth="300" class=""><div class="layui-table-cell laytable-cell-1-0-1"><a href="https://www.baidu.com/s?wd=layui 文档" target="_blank" class="layui-table-link">layui 文档</a></div></td><td data-field="frequency" data-key="1-0-2" data-minwidth="120" class=""><div class="layui-table-cell laytable-cell-1-0-2">666</div></td><td data-field="userNums" data-key="1-0-3" class=""><div class="layui-table-cell laytable-cell-1-0-3">333</div></td></tr><tr data-index="7"><td data-field="0" data-key="1-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-1-0-0 laytable-cell-numbers">8</div></td><td data-field="keywords" data-key="1-0-1" data-content="layui 文档" data-minwidth="300" class=""><div class="layui-table-cell laytable-cell-1-0-1"><a href="https://www.baidu.com/s?wd=layui 文档" target="_blank" class="layui-table-link">layui 文档</a></div></td><td data-field="frequency" data-key="1-0-2" data-minwidth="120" class=""><div class="layui-table-cell laytable-cell-1-0-2">666</div></td><td data-field="userNums" data-key="1-0-3" class=""><div class="layui-table-cell laytable-cell-1-0-3">333</div></td></tr><tr data-index="8"><td data-field="0" data-key="1-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-1-0-0 laytable-cell-numbers">9</div></td><td data-field="keywords" data-key="1-0-1" data-content="layui 文档" data-minwidth="300" class=""><div class="layui-table-cell laytable-cell-1-0-1"><a href="https://www.baidu.com/s?wd=layui 文档" target="_blank" class="layui-table-link">layui 文档</a></div></td><td data-field="frequency" data-key="1-0-2" data-minwidth="120" class=""><div class="layui-table-cell laytable-cell-1-0-2">666</div></td><td data-field="userNums" data-key="1-0-3" class=""><div class="layui-table-cell laytable-cell-1-0-3">333</div></td></tr><tr data-index="9"><td data-field="0" data-key="1-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-1-0-0 laytable-cell-numbers">10</div></td><td data-field="keywords" data-key="1-0-1" data-content="layui 文档" data-minwidth="300" class=""><div class="layui-table-cell laytable-cell-1-0-1"><a href="https://www.baidu.com/s?wd=layui 文档" target="_blank" class="layui-table-link">layui 文档</a></div></td><td data-field="frequency" data-key="1-0-2" data-minwidth="120" class=""><div class="layui-table-cell laytable-cell-1-0-2">666</div></td><td data-field="userNums" data-key="1-0-3" class=""><div class="layui-table-cell laytable-cell-1-0-3">333</div></td></tr></tbody></table></div><div class="layui-table-fixed layui-table-fixed-l"><div class="layui-table-header"><table cellspacing="0" cellpadding="0" border="0" class="layui-table" lay-skin="line"><thead><tr><th data-field="0" data-key="1-0-0" data-unresize="true" class=" layui-table-col-special"><div class="layui-table-cell laytable-cell-1-0-0 laytable-cell-numbers"><span></span></div></th></tr></thead></table></div><div class="layui-table-body" style="height: 390px;"><table cellspacing="0" cellpadding="0" border="0" class="layui-table" lay-skin="line"><tbody><tr data-index="0"><td data-field="0" data-key="1-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-1-0-0 laytable-cell-numbers">1</div></td></tr><tr data-index="1"><td data-field="0" data-key="1-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-1-0-0 laytable-cell-numbers">2</div></td></tr><tr data-index="2"><td data-field="0" data-key="1-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-1-0-0 laytable-cell-numbers">3</div></td></tr><tr data-index="3"><td data-field="0" data-key="1-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-1-0-0 laytable-cell-numbers">4</div></td></tr><tr data-index="4"><td data-field="0" data-key="1-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-1-0-0 laytable-cell-numbers">5</div></td></tr><tr data-index="5"><td data-field="0" data-key="1-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-1-0-0 laytable-cell-numbers">6</div></td></tr><tr data-index="6"><td data-field="0" data-key="1-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-1-0-0 laytable-cell-numbers">7</div></td></tr><tr data-index="7"><td data-field="0" data-key="1-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-1-0-0 laytable-cell-numbers">8</div></td></tr><tr data-index="8"><td data-field="0" data-key="1-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-1-0-0 laytable-cell-numbers">9</div></td></tr><tr data-index="9"><td data-field="0" data-key="1-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-1-0-0 laytable-cell-numbers">10</div></td></tr></tbody></table></div></div></div><div class="layui-table-page"><div id="layui-table-page1"><div class="layui-box layui-laypage layui-laypage-default" id="layui-laypage-1"><a href="javascript:;" class="layui-laypage-prev layui-disabled" data-page="0"><i class="layui-icon"></i></a><span class="layui-laypage-curr"><em class="layui-laypage-em"></em><em>1</em></span><a href="javascript:;" data-page="2">2</a><a href="javascript:;" data-page="3">3</a><span class="layui-laypage-spr">…</span><a href="javascript:;" class="layui-laypage-last" title="尾页" data-page="10">10</a><a href="javascript:;" class="layui-laypage-next" data-page="2"><i class="layui-icon"></i></a><span class="layui-laypage-skip">到第<input type="text" min="1" value="1" class="layui-input">页<button type="button" class="layui-laypage-btn">确定</button></span><span class="layui-laypage-count">共 100 条</span><span class="layui-laypage-limits"><select lay-ignore=""><option value="10" selected="">10 条/页</option><option value="20">20 条/页</option><option value="30">30 条/页</option><option value="40">40 条/页</option><option value="50">50 条/页</option><option value="60">60 条/页</option><option value="70">70 条/页</option><option value="80">80 条/页</option><option value="90">90 条/页</option></select></span></div></div></div><style>.laytable-cell-1-0-0{ width: 40px; }.laytable-cell-1-0-1{  }.laytable-cell-1-0-2{  }.laytable-cell-1-0-3{  }</style></div>
                  </div>
                  <div class="layui-tab-item" style="">
                    <table id="LAY-index-topCard"></table><div class="layui-form layui-border-box layui-table-view" lay-filter="LAY-table-2" lay-id="LAY-index-topCard" style=" "><div class="layui-table-box"><div class="layui-table-header"><table cellspacing="0" cellpadding="0" border="0" class="layui-table" lay-skin="line"><thead><tr><th data-field="0" data-key="2-0-0" data-unresize="true" class=" layui-table-col-special"><div class="layui-table-cell laytable-cell-2-0-0 laytable-cell-numbers"><span></span></div></th><th data-field="title" data-key="2-0-1" data-minwidth="300" class=""><div class="layui-table-cell laytable-cell-2-0-1"><span>标题</span></div></th><th data-field="username" data-key="2-0-2" class=""><div class="layui-table-cell laytable-cell-2-0-2"><span>发帖者</span></div></th><th data-field="channel" data-key="2-0-3" class=""><div class="layui-table-cell laytable-cell-2-0-3"><span>类别</span></div></th><th data-field="crt" data-key="2-0-4" class=" layui-unselect"><div class="layui-table-cell laytable-cell-2-0-4"><span>点击率</span><span class="layui-table-sort layui-inline"><i class="layui-edge layui-table-sort-asc" title="升序"></i><i class="layui-edge layui-table-sort-desc" title="降序"></i></span></div></th></tr></thead></table></div><div class="layui-table-body layui-table-main"><table cellspacing="0" cellpadding="0" border="0" class="layui-table" lay-skin="line"><tbody><tr data-index="0"><td data-field="0" data-key="2-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-2-0-0 laytable-cell-numbers">1</div></td><td data-field="title" data-key="2-0-1" data-content="社区开始接受 “赞助商广告” 投放" data-minwidth="300" class=""><div class="layui-table-cell laytable-cell-2-0-1"><a href="http://www.baidu.com/jie/15697/" target="_blank" class="layui-table-link">社区开始接受 “赞助商广告” 投放</a></div></td><td data-field="username" data-key="2-0-2" class=""><div class="layui-table-cell laytable-cell-2-0-2">贤心</div></td><td data-field="channel" data-key="2-0-3" class=""><div class="layui-table-cell laytable-cell-2-0-3">公告</div></td><td data-field="crt" data-key="2-0-4" class=""><div class="layui-table-cell laytable-cell-2-0-4">61632</div></td></tr><tr data-index="1"><td data-field="0" data-key="2-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-2-0-0 laytable-cell-numbers">2</div></td><td data-field="title" data-key="2-0-1" data-content="layui 一周年" data-minwidth="300" class=""><div class="layui-table-cell laytable-cell-2-0-1"><a href="http://www.baidu.com/jie/16622/" target="_blank" class="layui-table-link">layui 一周年</a></div></td><td data-field="username" data-key="2-0-2" class=""><div class="layui-table-cell laytable-cell-2-0-2">猫吃</div></td><td data-field="channel" data-key="2-0-3" class=""><div class="layui-table-cell laytable-cell-2-0-3">讨论</div></td><td data-field="crt" data-key="2-0-4" class=""><div class="layui-table-cell laytable-cell-2-0-4">61632</div></td></tr><tr data-index="2"><td data-field="0" data-key="2-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-2-0-0 laytable-cell-numbers">3</div></td><td data-field="title" data-key="2-0-1" data-content="四个月的前端" data-minwidth="300" class=""><div class="layui-table-cell laytable-cell-2-0-1"><a href="http://www.baidu.com/jie/16651/" target="_blank" class="layui-table-link">四个月的前端</a></div></td><td data-field="username" data-key="2-0-2" class=""><div class="layui-table-cell laytable-cell-2-0-2">fd</div></td><td data-field="channel" data-key="2-0-3" class=""><div class="layui-table-cell laytable-cell-2-0-3">分享</div></td><td data-field="crt" data-key="2-0-4" class=""><div class="layui-table-cell laytable-cell-2-0-4">61632</div></td></tr><tr data-index="3"><td data-field="0" data-key="2-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-2-0-0 laytable-cell-numbers">4</div></td><td data-field="title" data-key="2-0-1" data-content="如何评价LayUI和他的作者闲心" data-minwidth="300" class=""><div class="layui-table-cell laytable-cell-2-0-1"><a href="http://www.baidu.com/jie/9352/" target="_blank" class="layui-table-link">如何评价LayUI和他的作者闲心</a></div></td><td data-field="username" data-key="2-0-2" class=""><div class="layui-table-cell laytable-cell-2-0-2">纸飞机</div></td><td data-field="channel" data-key="2-0-3" class=""><div class="layui-table-cell laytable-cell-2-0-3">提问</div></td><td data-field="crt" data-key="2-0-4" class=""><div class="layui-table-cell laytable-cell-2-0-4">61632</div></td></tr><tr data-index="4"><td data-field="0" data-key="2-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-2-0-0 laytable-cell-numbers">5</div></td><td data-field="title" data-key="2-0-1" data-content="如何评价LayUI和他的作者闲心" data-minwidth="300" class=""><div class="layui-table-cell laytable-cell-2-0-1"><a href="http://www.baidu.com/jie/9352/" target="_blank" class="layui-table-link">如何评价LayUI和他的作者闲心</a></div></td><td data-field="username" data-key="2-0-2" class=""><div class="layui-table-cell laytable-cell-2-0-2">纸飞机</div></td><td data-field="channel" data-key="2-0-3" class=""><div class="layui-table-cell laytable-cell-2-0-3">提问</div></td><td data-field="crt" data-key="2-0-4" class=""><div class="layui-table-cell laytable-cell-2-0-4">61632</div></td></tr><tr data-index="5"><td data-field="0" data-key="2-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-2-0-0 laytable-cell-numbers">6</div></td><td data-field="title" data-key="2-0-1" data-content="如何评价LayUI和他的作者闲心" data-minwidth="300" class=""><div class="layui-table-cell laytable-cell-2-0-1"><a href="http://www.baidu.com/jie/9352/" target="_blank" class="layui-table-link">如何评价LayUI和他的作者闲心</a></div></td><td data-field="username" data-key="2-0-2" class=""><div class="layui-table-cell laytable-cell-2-0-2">纸飞机</div></td><td data-field="channel" data-key="2-0-3" class=""><div class="layui-table-cell laytable-cell-2-0-3">提问</div></td><td data-field="crt" data-key="2-0-4" class=""><div class="layui-table-cell laytable-cell-2-0-4">61632</div></td></tr><tr data-index="6"><td data-field="0" data-key="2-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-2-0-0 laytable-cell-numbers">7</div></td><td data-field="title" data-key="2-0-1" data-content="如何评价LayUI和他的作者闲心" data-minwidth="300" class=""><div class="layui-table-cell laytable-cell-2-0-1"><a href="http://www.baidu.com/jie/9352/" target="_blank" class="layui-table-link">如何评价LayUI和他的作者闲心</a></div></td><td data-field="username" data-key="2-0-2" class=""><div class="layui-table-cell laytable-cell-2-0-2">纸飞机</div></td><td data-field="channel" data-key="2-0-3" class=""><div class="layui-table-cell laytable-cell-2-0-3">提问</div></td><td data-field="crt" data-key="2-0-4" class=""><div class="layui-table-cell laytable-cell-2-0-4">61632</div></td></tr><tr data-index="7"><td data-field="0" data-key="2-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-2-0-0 laytable-cell-numbers">8</div></td><td data-field="title" data-key="2-0-1" data-content="如何评价LayUI和他的作者闲心" data-minwidth="300" class=""><div class="layui-table-cell laytable-cell-2-0-1"><a href="http://www.baidu.com/jie/9352/" target="_blank" class="layui-table-link">如何评价LayUI和他的作者闲心</a></div></td><td data-field="username" data-key="2-0-2" class=""><div class="layui-table-cell laytable-cell-2-0-2">纸飞机</div></td><td data-field="channel" data-key="2-0-3" class=""><div class="layui-table-cell laytable-cell-2-0-3">提问</div></td><td data-field="crt" data-key="2-0-4" class=""><div class="layui-table-cell laytable-cell-2-0-4">61632</div></td></tr><tr data-index="8"><td data-field="0" data-key="2-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-2-0-0 laytable-cell-numbers">9</div></td><td data-field="title" data-key="2-0-1" data-content="如何评价LayUI和他的作者闲心" data-minwidth="300" class=""><div class="layui-table-cell laytable-cell-2-0-1"><a href="http://www.baidu.com/jie/9352/" target="_blank" class="layui-table-link">如何评价LayUI和他的作者闲心</a></div></td><td data-field="username" data-key="2-0-2" class=""><div class="layui-table-cell laytable-cell-2-0-2">纸飞机</div></td><td data-field="channel" data-key="2-0-3" class=""><div class="layui-table-cell laytable-cell-2-0-3">提问</div></td><td data-field="crt" data-key="2-0-4" class=""><div class="layui-table-cell laytable-cell-2-0-4">61632</div></td></tr><tr data-index="9"><td data-field="0" data-key="2-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-2-0-0 laytable-cell-numbers">10</div></td><td data-field="title" data-key="2-0-1" data-content="如何评价LayUI和他的作者闲心" data-minwidth="300" class=""><div class="layui-table-cell laytable-cell-2-0-1"><a href="http://www.baidu.com/jie/9352/" target="_blank" class="layui-table-link">如何评价LayUI和他的作者闲心</a></div></td><td data-field="username" data-key="2-0-2" class=""><div class="layui-table-cell laytable-cell-2-0-2">纸飞机</div></td><td data-field="channel" data-key="2-0-3" class=""><div class="layui-table-cell laytable-cell-2-0-3">提问</div></td><td data-field="crt" data-key="2-0-4" class=""><div class="layui-table-cell laytable-cell-2-0-4">61632</div></td></tr></tbody></table></div><div class="layui-table-fixed layui-table-fixed-l"><div class="layui-table-header"><table cellspacing="0" cellpadding="0" border="0" class="layui-table" lay-skin="line"><thead><tr><th data-field="0" data-key="2-0-0" data-unresize="true" class=" layui-table-col-special"><div class="layui-table-cell laytable-cell-2-0-0 laytable-cell-numbers"><span></span></div></th></tr></thead></table></div><div class="layui-table-body" style="height: 0px;"><table cellspacing="0" cellpadding="0" border="0" class="layui-table" lay-skin="line"><tbody><tr data-index="0"><td data-field="0" data-key="2-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-2-0-0 laytable-cell-numbers">1</div></td></tr><tr data-index="1"><td data-field="0" data-key="2-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-2-0-0 laytable-cell-numbers">2</div></td></tr><tr data-index="2"><td data-field="0" data-key="2-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-2-0-0 laytable-cell-numbers">3</div></td></tr><tr data-index="3"><td data-field="0" data-key="2-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-2-0-0 laytable-cell-numbers">4</div></td></tr><tr data-index="4"><td data-field="0" data-key="2-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-2-0-0 laytable-cell-numbers">5</div></td></tr><tr data-index="5"><td data-field="0" data-key="2-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-2-0-0 laytable-cell-numbers">6</div></td></tr><tr data-index="6"><td data-field="0" data-key="2-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-2-0-0 laytable-cell-numbers">7</div></td></tr><tr data-index="7"><td data-field="0" data-key="2-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-2-0-0 laytable-cell-numbers">8</div></td></tr><tr data-index="8"><td data-field="0" data-key="2-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-2-0-0 laytable-cell-numbers">9</div></td></tr><tr data-index="9"><td data-field="0" data-key="2-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-2-0-0 laytable-cell-numbers">10</div></td></tr></tbody></table></div></div></div><div class="layui-table-page"><div id="layui-table-page2"><div class="layui-box layui-laypage layui-laypage-default" id="layui-laypage-2"><a href="javascript:;" class="layui-laypage-prev layui-disabled" data-page="0"><i class="layui-icon"></i></a><span class="layui-laypage-curr"><em class="layui-laypage-em"></em><em>1</em></span><a href="javascript:;" data-page="2">2</a><a href="javascript:;" data-page="3">3</a><span class="layui-laypage-spr">…</span><a href="javascript:;" class="layui-laypage-last" title="尾页" data-page="10">10</a><a href="javascript:;" class="layui-laypage-next" data-page="2"><i class="layui-icon"></i></a><span class="layui-laypage-skip">到第<input type="text" min="1" value="1" class="layui-input">页<button type="button" class="layui-laypage-btn">确定</button></span><span class="layui-laypage-count">共 100 条</span><span class="layui-laypage-limits"><select lay-ignore=""><option value="10" selected="">10 条/页</option><option value="20">20 条/页</option><option value="30">30 条/页</option><option value="40">40 条/页</option><option value="50">50 条/页</option><option value="60">60 条/页</option><option value="70">70 条/页</option><option value="80">80 条/页</option><option value="90">90 条/页</option></select></span></div></div></div><style>.laytable-cell-2-0-0{ width: 40px; }.laytable-cell-2-0-1{  }.laytable-cell-2-0-2{  }.laytable-cell-2-0-3{  }.laytable-cell-2-0-4{  }</style></div>
                  </div>
                </div>
              </div>
            </div>
          </div>



        </div>
      </div>
      
      <div class="layui-col-md4">
        <div class="layui-card">
          <div class="layui-card-header">版本信息</div>
          <div class="layui-card-body layui-text layadmin-version">
            <table class="layui-table">
              <colgroup>
                <col width="100">
                <col>
              </colgroup>
              <tbody>
                <tr>
                  <td>模板名称</td>
                  <td>
                    layuiAdmin
                  </td>
                </tr>
                <tr>
                  <td>当前版本</td>
                  <td>
                    <script type="text/html" template="">
                      v{{ layui.admin.v }}
                    </script> v1.7.0 std 
                  </td>
                </tr>
                <tr>
                  <td>UI 版本</td>
                  <td>
                    <script type="text/html" template="">
                      layui-v{{ layui.v }}
                    </script> layui-v2.6.7 
                 </td>
                </tr>
                <tr>
                  <td>主要特色</td>
                  <td>零门槛 / 响应式 / 清爽 / 极简</td>
                </tr>
                
              </tbody>
            </table>
          </div>
        </div>
        
        <div class="layui-card">
          <div class="layui-card-header">效果报告</div>
          <div class="layui-card-body layadmin-takerates">
            <div class="layui-progress" lay-showpercent="yes">
              <h3>转化率（日同比 28% <span class="layui-edge layui-edge-top" lay-tips="增长" lay-offset="-15"></span>）</h3>
              <div class="layui-progress-bar" lay-percent="65%" style="width: 65%;"><span class="layui-progress-text">65%</span></div>
            </div>
            <div class="layui-progress" lay-showpercent="yes">
              <h3>签到率（日同比 11% <span class="layui-edge layui-edge-bottom" lay-tips="下降" lay-offset="-15"></span>）</h3>
              <div class="layui-progress-bar" lay-percent="32%" style="width: 32%;"><span class="layui-progress-text">32%</span></div>
            </div>
          </div>
        </div>
        
        <div class="layui-card">
          <div class="layui-card-header">进度占用</div>
          <div class="layui-card-body layadmin-takerates">
            <div class="layui-progress" lay-showpercent="yes">
              <h3>CPU 使用率</h3>
              <div class="layui-progress-bar" lay-percent="58%" style="width: 58%;"><span class="layui-progress-text">58%</span></div>
            </div>
            <div class="layui-progress" lay-showpercent="yes">
              <h3>内存占用率</h3>
              <div class="layui-progress-bar layui-bg-red" lay-percent="90%" style="width: 90%;"><span class="layui-progress-text">90%</span></div>
            </div>
          </div>
        </div>

        <div class="layui-card">
          <div class="layui-card-header">项目进展</div>
          <div class="layui-card-body" style="padding: 22px 15px;">
            <table id="LAY-home-homepage-console"></table><div class="layui-form layui-border-box layui-table-view" lay-filter="LAY-table-3" lay-id="LAY-home-homepage-console" style=" "><div class="layui-table-box"><div class="layui-table-header"><table cellspacing="0" cellpadding="0" border="0" class="layui-table" lay-skin="line"><thead><tr><th data-field="0" data-key="3-0-0" data-unresize="true" class=" layui-table-col-special"><div class="layui-table-cell laytable-cell-3-0-0 laytable-cell-checkbox"><input type="checkbox" name="layTableCheckbox" lay-skin="primary" lay-filter="layTableAllChoose"><div class="layui-unselect layui-form-checkbox" lay-skin="primary"><i class="layui-icon layui-icon-ok"></i></div></div></th><th data-field="prograss" data-key="3-0-1" class=""><div class="layui-table-cell laytable-cell-3-0-1"><span>任务</span></div></th><th data-field="time" data-key="3-0-2" class=""><div class="layui-table-cell laytable-cell-3-0-2"><span>所需时间</span></div></th><th data-field="complete" data-key="3-0-3" class=""><div class="layui-table-cell laytable-cell-3-0-3"><span>完成情况</span></div></th></tr></thead></table></div><div class="layui-table-body layui-table-main"><table cellspacing="0" cellpadding="0" border="0" class="layui-table" lay-skin="line"><tbody><tr data-index="0"><td data-field="0" data-key="3-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-3-0-0 laytable-cell-checkbox"><input type="checkbox" name="layTableCheckbox" lay-skin="primary" checked=""><div class="layui-unselect layui-form-checkbox layui-form-checked" lay-skin="primary"><i class="layui-icon layui-icon-ok"></i></div></div></td><td data-field="prograss" data-key="3-0-1" class=""><div class="layui-table-cell laytable-cell-3-0-1">开会</div></td><td data-field="time" data-key="3-0-2" class=""><div class="layui-table-cell laytable-cell-3-0-2">一小时</div></td><td data-field="complete" data-key="3-0-3" data-content="已完成" class=""><div class="layui-table-cell laytable-cell-3-0-3"><del style="color: #5FB878;">已完成</del></div></td></tr><tr data-index="1"><td data-field="0" data-key="3-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-3-0-0 laytable-cell-checkbox"><input type="checkbox" name="layTableCheckbox" lay-skin="primary" checked=""><div class="layui-unselect layui-form-checkbox layui-form-checked" lay-skin="primary"><i class="layui-icon layui-icon-ok"></i></div></div></td><td data-field="prograss" data-key="3-0-1" class=""><div class="layui-table-cell laytable-cell-3-0-1">项目开发</div></td><td data-field="time" data-key="3-0-2" class=""><div class="layui-table-cell laytable-cell-3-0-2">两小时</div></td><td data-field="complete" data-key="3-0-3" data-content="进行中" class=""><div class="layui-table-cell laytable-cell-3-0-3"><span style="color: #FFB800;">进行中</span></div></td></tr><tr data-index="2"><td data-field="0" data-key="3-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-3-0-0 laytable-cell-checkbox"><input type="checkbox" name="layTableCheckbox" lay-skin="primary"><div class="layui-unselect layui-form-checkbox" lay-skin="primary"><i class="layui-icon layui-icon-ok"></i></div></div></td><td data-field="prograss" data-key="3-0-1" class=""><div class="layui-table-cell laytable-cell-3-0-1">陪吃饭</div></td><td data-field="time" data-key="3-0-2" class=""><div class="layui-table-cell laytable-cell-3-0-2">一小时</div></td><td data-field="complete" data-key="3-0-3" data-content="未完成" class=""><div class="layui-table-cell laytable-cell-3-0-3"><span style="color: #FF5722;">未完成</span></div></td></tr><tr data-index="3"><td data-field="0" data-key="3-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-3-0-0 laytable-cell-checkbox"><input type="checkbox" name="layTableCheckbox" lay-skin="primary"><div class="layui-unselect layui-form-checkbox" lay-skin="primary"><i class="layui-icon layui-icon-ok"></i></div></div></td><td data-field="prograss" data-key="3-0-1" class=""><div class="layui-table-cell laytable-cell-3-0-1">修改小bug</div></td><td data-field="time" data-key="3-0-2" class=""><div class="layui-table-cell laytable-cell-3-0-2">半小时</div></td><td data-field="complete" data-key="3-0-3" data-content="未完成" class=""><div class="layui-table-cell laytable-cell-3-0-3"><span style="color: #FF5722;">未完成</span></div></td></tr><tr data-index="4"><td data-field="0" data-key="3-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-3-0-0 laytable-cell-checkbox"><input type="checkbox" name="layTableCheckbox" lay-skin="primary"><div class="layui-unselect layui-form-checkbox" lay-skin="primary"><i class="layui-icon layui-icon-ok"></i></div></div></td><td data-field="prograss" data-key="3-0-1" class=""><div class="layui-table-cell laytable-cell-3-0-1">修改大bug</div></td><td data-field="time" data-key="3-0-2" class=""><div class="layui-table-cell laytable-cell-3-0-2">两小时</div></td><td data-field="complete" data-key="3-0-3" data-content="未完成" class=""><div class="layui-table-cell laytable-cell-3-0-3"><span style="color: #FF5722;">未完成</span></div></td></tr><tr data-index="5"><td data-field="0" data-key="3-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-3-0-0 laytable-cell-checkbox"><input type="checkbox" name="layTableCheckbox" lay-skin="primary"><div class="layui-unselect layui-form-checkbox" lay-skin="primary"><i class="layui-icon layui-icon-ok"></i></div></div></td><td data-field="prograss" data-key="3-0-1" class=""><div class="layui-table-cell laytable-cell-3-0-1">修改小bug</div></td><td data-field="time" data-key="3-0-2" class=""><div class="layui-table-cell laytable-cell-3-0-2">半小时</div></td><td data-field="complete" data-key="3-0-3" data-content="未完成" class=""><div class="layui-table-cell laytable-cell-3-0-3"><span style="color: #FF5722;">未完成</span></div></td></tr><tr data-index="6"><td data-field="0" data-key="3-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-3-0-0 laytable-cell-checkbox"><input type="checkbox" name="layTableCheckbox" lay-skin="primary"><div class="layui-unselect layui-form-checkbox" lay-skin="primary"><i class="layui-icon layui-icon-ok"></i></div></div></td><td data-field="prograss" data-key="3-0-1" class=""><div class="layui-table-cell laytable-cell-3-0-1">修改大bug</div></td><td data-field="time" data-key="3-0-2" class=""><div class="layui-table-cell laytable-cell-3-0-2">两小时</div></td><td data-field="complete" data-key="3-0-3" data-content="未完成" class=""><div class="layui-table-cell laytable-cell-3-0-3"><span style="color: #FF5722;">未完成</span></div></td></tr></tbody></table></div><div class="layui-table-fixed layui-table-fixed-l"><div class="layui-table-header"><table cellspacing="0" cellpadding="0" border="0" class="layui-table" lay-skin="line"><thead><tr><th data-field="0" data-key="3-0-0" data-unresize="true" class=" layui-table-col-special"><div class="layui-table-cell laytable-cell-3-0-0 laytable-cell-checkbox"><input type="checkbox" name="layTableCheckbox" lay-skin="primary" lay-filter="layTableAllChoose"><div class="layui-unselect layui-form-checkbox" lay-skin="primary"><i class="layui-icon layui-icon-ok"></i></div></div></th></tr></thead></table></div><div class="layui-table-body" style="height: 273px;"><table cellspacing="0" cellpadding="0" border="0" class="layui-table" lay-skin="line"><tbody><tr data-index="0"><td data-field="0" data-key="3-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-3-0-0 laytable-cell-checkbox"><input type="checkbox" name="layTableCheckbox" lay-skin="primary" checked=""><div class="layui-unselect layui-form-checkbox layui-form-checked" lay-skin="primary"><i class="layui-icon layui-icon-ok"></i></div></div></td></tr><tr data-index="1"><td data-field="0" data-key="3-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-3-0-0 laytable-cell-checkbox"><input type="checkbox" name="layTableCheckbox" lay-skin="primary" checked=""><div class="layui-unselect layui-form-checkbox layui-form-checked" lay-skin="primary"><i class="layui-icon layui-icon-ok"></i></div></div></td></tr><tr data-index="2"><td data-field="0" data-key="3-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-3-0-0 laytable-cell-checkbox"><input type="checkbox" name="layTableCheckbox" lay-skin="primary"><div class="layui-unselect layui-form-checkbox" lay-skin="primary"><i class="layui-icon layui-icon-ok"></i></div></div></td></tr><tr data-index="3"><td data-field="0" data-key="3-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-3-0-0 laytable-cell-checkbox"><input type="checkbox" name="layTableCheckbox" lay-skin="primary"><div class="layui-unselect layui-form-checkbox" lay-skin="primary"><i class="layui-icon layui-icon-ok"></i></div></div></td></tr><tr data-index="4"><td data-field="0" data-key="3-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-3-0-0 laytable-cell-checkbox"><input type="checkbox" name="layTableCheckbox" lay-skin="primary"><div class="layui-unselect layui-form-checkbox" lay-skin="primary"><i class="layui-icon layui-icon-ok"></i></div></div></td></tr><tr data-index="5"><td data-field="0" data-key="3-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-3-0-0 laytable-cell-checkbox"><input type="checkbox" name="layTableCheckbox" lay-skin="primary"><div class="layui-unselect layui-form-checkbox" lay-skin="primary"><i class="layui-icon layui-icon-ok"></i></div></div></td></tr><tr data-index="6"><td data-field="0" data-key="3-0-0" class="layui-table-col-special"><div class="layui-table-cell laytable-cell-3-0-0 laytable-cell-checkbox"><input type="checkbox" name="layTableCheckbox" lay-skin="primary"><div class="layui-unselect layui-form-checkbox" lay-skin="primary"><i class="layui-icon layui-icon-ok"></i></div></div></td></tr></tbody></table></div></div></div><style>.laytable-cell-3-0-0{ width: 48px; }.laytable-cell-3-0-1{  }.laytable-cell-3-0-2{  }.laytable-cell-3-0-3{  }</style></div>
          </div>
        </div>
        
        <div class="layui-card">
          <div class="layui-card-header">产品动态</div>
          <div class="layui-card-body">
            <div class="layui-carousel layadmin-carousel layadmin-news" data-autoplay="true" data-anim="fade" lay-filter="news" lay-anim="fade" lay-indicator="inside" lay-arrow="none" style="width: 100%; height: 280px;">
              <div carousel-item="">
                <div class=""><a href="#" class="layui-bg-red">layuiAdmin 快速上手文档</a></div>
                <div class=""><a href="#" class="layui-bg-green">layuiAdmin 技术问答专区</a></div> 
                <div class="layui-this"><a href="#" class="layui-bg-blue">layuiAdmin 模板官网</a></div>
              </div>
            <div class="layui-carousel-ind"><ul><li class=""></li><li class=""></li><li class="layui-this"></li></ul></div><button class="layui-icon layui-carousel-arrow" lay-type="sub"></button><button class="layui-icon layui-carousel-arrow" lay-type="add"></button></div>
          </div>
        </div>

        <div class="layui-card">
          <div class="layui-card-header">
            作者心语
            <i class="layui-icon layui-icon-tips" lay-tips="要支持的噢" lay-offset="5"></i>
          </div>
          <div class="layui-card-body layui-text layadmin-text">
            <blockquote class="layui-elem-quote">
              <p>一直以来，layui 秉承无偿开源的初心，虔诚致力于服务各层次前后端 Web 开发者，在商业横飞的当今时代，这一信念从未动摇。即便身单力薄，仍然重拾决心，埋头造轮，以尽可能地填补产品本身的缺口。</p>
              <p>在过去的一段的时间，我一直在寻求持久之道，已维持你眼前所见的一切。而 layuiAdmin 是我们尝试解决的手段之一。我相信真正有爱于 layui 生态的你，定然不会错过这一拥抱吧。</p>
              <p>子曰：君子不用防，小人防不住。请务必通过官网正规渠道，获得 layuiAdmin！</p>
              <p>—— 贤心 layui</p>
            </blockquote>
          </div>
        </div>
      </div>
      
    </div>
  </div>
</body>
</html>