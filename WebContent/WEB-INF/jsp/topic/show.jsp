<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>查看主题：新手发帖</title>
   <%@include file="/WEB-INF/jsp/public/header.jsp" %>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/style/blue/forum.css" />
	 <script type="text/javascript" src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/ckeditor/samples/sample.css" >
	<script language="javascript" src="${pageContext.request.contextPath }/script/fckeditor/fckeditor.js" charset="utf-8"></script>
    
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath }/style/images/title_arrow.gif"/> 查看主题
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--内容显示-->	
<div id="MainArea">
	<div id="PageHead"></div>
	<center>
		<div class="ItemBlock_Title1" style="width: 98%">
			<font class="MenuPoint"> &gt; </font>
			<s:a action="forum_list" namespace="/">论坛</s:a>
			<font class="MenuPoint"> &gt; </font>
			<s:a action="forum_show?id=%{forum.id}" namespace="/">${ forum.name}常见问题</s:a>
			<font class="MenuPoint"> &gt;&gt; </font>
			${title }
			<span style="margin-left:30px;">
			<s:a action="topic_addUI?forumId=%{forum.id}" namespace="/">
				<img align="absmiddle" src="${pageContext.request.contextPath }/style/blue/images/button/publishNewTopic.png"/>
				</s:a>
			</span>
		</div>
		
		<div class="ForumPageTableBorder dataContainer" datakey="replyList">
		
			<!--显示主题标题等-->
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr valign="bottom">
				<td width="3" class="ForumPageTableTitleLeft">&nbsp;</td>
					<td class="ForumPageTableTitle"><b>本帖主题：${title }</b></td>
					<td class="ForumPageTableTitle" align="right" style="padding-right:12px;">
					<s:a cssClass="detail" action="reply_addUI?topicId=%{id}" namespace="/" >
					<img border="0" src="${pageContext.request.contextPath }/style/images/reply.gif" />回复</s:a>
						
					</td>
					<td width="3" class="ForumPageTableTitleRight">&nbsp;</td>
				</tr>
				<tr height="1" class="ForumPageTableTitleLine"><td colspan="4"></td></tr>
			</table>

			<!-- ~~~~~~~~~~~~~~~ 显示主帖 ~~~~~~~~~~~~~~~ -->
			<div class="ListArea">
				<table border="0" cellpadding="0" cellspacing="1" width="100%">
					<tr>
						<td rowspan="3" width="130" class="PhotoArea" align="center" valign="top">
							<!--作者头像-->
							<div class="AuthorPhoto">
								<img border="0" width="110" height="110" src="${pageContext.request.contextPath }/style/images/defaultAvatar.gif" 
									onerror="this.onerror=null; this.src='${pageContext.request.contextPath }/style/images/defaultAvatar.gif';" />
							</div>
							<!--作者名称-->
							<div class="AuthorName">${author.name}</div>
						</td>
						
					</tr>
					<tr><!-- 文章内容 -->
						<td valign="top" align="center">
							<div class="Content">content</div>
						</td>
					</tr>
					<tr><!--显示楼层等信息-->
						<td class="Footer" height="28" align="center" valign="bottom">
							<ul style="margin: 0px; width: 98%;">
								<li style="float: left; line-height:18px;"><font color=#C30000>[楼主]</font>
									<s:date name="postTime" format="yyyy-MM-dd  HH:mm:ss"></s:date>
								</li>
								<li style="float: right;"><a href="javascript:scroll(0,0)">
									<img border="0" src="${pageContext.request.contextPath }/style/images/top.gif" /></a>
								</li>
							</ul>
						</td>
					</tr>
				</table>
			</div>
			<!-- ~~~~~~~~~~~~~~~ 显示主帖结束 ~~~~~~~~~~~~~~~ -->


			<!-- ~~~~~~~~~~~~~~~ 显示回复列表 ~~~~~~~~~~~~~~~ -->
			<div class="ListArea template">
			<s:iterator value="relpylist" status="s" >
				<table border="0" cellpadding="0" cellspacing="1" width="100%">
				
					<tr>
						<td rowspan="3" width="130" class="PhotoArea" align="center" valign="top">
							<!--作者头像-->
							<div class="AuthorPhoto">
								<img border="0" width="110" height="110" src="${pageContext.request.contextPath }/style/images/defaultAvatar.gif" 
									onerror="this.onerror=null; this.src='${pageContext.request.contextPath }/style/images/defaultAvatar.gif';" />
							</div>
							<!--作者名称-->
							<div class="AuthorName">${author.name}</div>
						</td>
						
					</tr>
					<tr><!-- 文章内容 -->
						<td valign="top" align="center">
							<div class="Content">${content}</div>
						</td>
					</tr>
					<tr><!--显示楼层等信息-->
						<td class="Footer" height="28" align="center" valign="bottom">
							<ul style="margin: 0px; width: 98%;">
								<li style="float: left; line-height:18px;"><font color=#C30000>[
								<s:property value="#s.count"/>
								楼]</font>
									<s:date name="postTime" format="yyyy-MM-dd  HH:mm:ss"/>
								</li>
								<li style="float: right;"><a href="javascript:scroll(0,0)">
									<img border="0" src="${pageContext.request.contextPath }/style/images/top.gif" /></a>
								</li>
							</ul>
						</td>
					</tr>
					
				</table>
				</s:iterator>
			</div>
			<!-- ~~~~~~~~~~~~~~~ 显示回复列表结束 ~~~~~~~~~~~~~~~ -->
		</div>

		<!--分页信息-->
		<div id=PageSelectorBar>
			<div id=PageSelectorMemo>
				页次：7/13页 &nbsp;
				每页显示：30条 &nbsp;
				总记录数：385条
			</div>
			<div id=PageSelectorSelectorArea>
				<!--
				<IMG SRC="${pageContext.request.contextPath }/style/blue/images/pageSelector/firstPage2.png"/>
				-->
				<a href="javascript:void(0)" title="首页" style="cursor: hand;">
					<img src="${pageContext.request.contextPath }/style/blue/images/pageSelector/firstPage.png"/></a>
				
				<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPageNum(2);">3</span>
				<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPageNum(2);">4</span>
				<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPageNum(2);">5</span>
				<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPageNum(2);">6</span>
				<span class="PageSelectorNum PageSelectorSelected">7</span>
				<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPageNum(2);">8</span>
				<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPageNum(2);">9</span>
				<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPageNum(2);">10</span>
				<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPageNum(2);">11</span>
				<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPageNum(2);">12</span>
				
				<!--
				<IMG SRC="${pageContext.request.contextPath }/style/blue/images/pageSelector/lastPage2.png"/>
				-->
				<a href="#" title="尾页" style="cursor: hand;">
					<img src="${pageContext.request.contextPath }/style/blue/images/pageSelector/lastPage.png"/></a>
				
				转到：
				<input onFocus="this.select();" maxlength="2" class="inputStyle" type="text" value="1" name="currPage" tabindex="0"/>
				<input type="submit" name="goBtn" value="Go" class="MiddleButtonStyle" />
			</div>
		</div>

		<div class="ForumPageTableBorder" style="margin-top: 25px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr valign="bottom">
					<td width="3" class="ForumPageTableTitleLeft">&nbsp;</td>
					<td class="ForumPageTableTitle"><b>快速回复</b></td>
					<td width="3" class="ForumPageTableTitleRight">&nbsp;</td>
				</tr>
				<tr height="1" class="ForumPageTableTitleLine">
					<td colspan="3"></td>
				</tr>
			</table>
		</div>
	</center>
			
	<!--快速回复-->
	<div class="QuictReply">
	<s:form action="reply_add" namespace="/" method="post">
	<input type="hidden" name="topicId" value="${ id}">
		<div style="padding-left: 3px;">
			<table border="0" cellspacing="1" width="98%" cellpadding="5" class="TableStyle">
				<tr class="Tint" height="200">
					<td valign="top" rowspan="2" class="Deep"><b>内容</b></td>
					<td valign="top" class="no_color_bg">
						<textarea id="content" name="content" style="width: 95%; height: 300px"></textarea>
					</td>
				</tr>
				<tr height="30" class="Tint">
					<td class="no_color_bg" colspan="2" align="center">
						<input type="image" src="${pageContext.request.contextPath }/style/blue/images/button/submit.PNG" style="margin-right:15px;"/>
					</td>
				</tr>
			</table>
		</div>
	</s:form>
	</div>
</div>
<!-- 下面是为了使用比那机器使用的js -->
<script>
		CKEDITOR.replace( 'content', {
			uiColor: '#14B8C4',
			/* toolbar: [
				['Source','-', 'Bold', 'Italic', '-', 'NumberedList', 'BulletedList', '-', 'Link', 'Unlink' ],
				[ 'FontSize', 'TextColor', 'BGColor' ]
			] */
		});
</script>
</body>
</html>
