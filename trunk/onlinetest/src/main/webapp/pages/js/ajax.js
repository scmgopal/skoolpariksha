/**
	Common File to get Ajax Utility
	
	The following JS file contains script that can be used to call CallAjaxRequest Function. 
	CallAjaxRequest Function takes two arguments :
	
	a) The URL of Action
	b) Placeholder which is the id of the element in which the received response will be set. 
	
	How it Works:
	1. It creates the XMLHttpRequest object 
	2. It then send request to Server
	3. It then Update the WebPage at the PlaceHolder

*/

	function GetXmlHttpObject()
	{
  		var xmlHttp=null;
  		try
    	{
    		// Firefox, Opera 8.0+, Safari
    		xmlHttp=new XMLHttpRequest();
    	}
  		catch (e)
    	{
    		// Internet Explorer
    		try
      		{
      			xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
      		}
    		catch (e)
      		{
      			xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
      		}
    	}
  		return xmlHttp;
	}
	
	function  CallAjaxRequest(url, placeHolder)
	{
		xmlHttp=GetXmlHttpObject();
		if (xmlHttp==null)
  		{
  			alert ("Your browser does not support AJAX!");
  			return;
  		}
  		 
		xmlHttp.onreadystatechange = function()
		{ 
			if(xmlHttp.readyState==4)
			{
				if(xmlHttp.status==200)
				{
					if(document.getElementById(placeHolder))
					{
						document.getElementById(placeHolder).innerHTML=xmlHttp.responseText;
						resetTimeOut();
					}
					else
					{
						alert("No Such Place Holder Exists");
					}
				}
				else
				{
					alert("An error has occurred: " + xmlHttp.statusText);
				}
			}
		};
		url=url+"&sid="+Math.random();
		xmlHttp.open("POST",url,false);
		xmlHttp.send(null);
	}
	
	
	function ajaxRequestCall(url) {
		var responseText = "";
		xmlHttp=GetXmlHttpObject();
		if (xmlHttp==null) {
  			alert ("Your browser does not support AJAX!");
  			return;
  		}
  		 
		xmlHttp.onreadystatechange = function() { 
			if (xmlHttp.readyState==4) {
				if (xmlHttp.status==200) {
					responseText = xmlHttp.responseText;
				} else {
					alert("An error has occurred: " + xmlHttp.statusText);
				}
			}
		};
		url=url+"&sid="+Math.random();
		xmlHttp.open("POST",url,false);
		xmlHttp.send(null);
		return responseText;
	}

	/**
	 * 
	 * @param url
	 * @param placeHolder
	 * @param postData
	 * @return
	 */
	function CallAjaxRequestWithPostData(url, placeHolder, postData)
	{
		xmlHttpObj = GetXmlHttpObject();
		if (xmlHttpObj == null)
  		{
  			alert ("Your browser does not support AJAX!");
  			return;
  		}
  		
	  	xmlHttpObj.open("POST",url,false);
	  	xmlHttpObj.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xmlHttpObj.setRequestHeader("Content-length", postData.length);
		xmlHttpObj.setRequestHeader("Connection", "close"); 
  		 
		xmlHttpObj.onreadystatechange = function()
		{ 
			if(xmlHttpObj.readyState == 4)
			{
				if(xmlHttpObj.status == 200)
				{
					if(document.getElementById(placeHolder))
					{
						document.getElementById(placeHolder).innerHTML = xmlHttpObj.responseText;
						resetTimeOut();
					}
					else
					{
						alert("No Such Place Holder Exists");
					}
				}
				else
				{
					alert("An error has occurred: " + xmlHttpObj.statusText);
				}
			}
		};
		//url=url+"&sid="+Math.random();
		//xmlHttp.open("POST",url,false);
		xmlHttpObj.send(postData);
	}

	
	/**This method sends the http request to the specified url with post method
	 * and if callback routine is not null or empty then  pass the response text
	 * to the callback routine for further processing.
	 * 
	 * @param url - url is the action to perform
	 * @param postData - any data which will be send using post method
	 * @param callback - callback is the routine name which will be
	 * 					called on success with responseText
	 * @return
	 */
	function CallAjaxPostRequestWithCallback(url, postData, callback)
	{
		xmlHttpObj = GetXmlHttpObject();
		if (xmlHttpObj == null)
  		{
  			alert ("Your browser does not support AJAX!");
  			return;
  		}
  		
	  	xmlHttpObj.open("POST",url,false);
	  	xmlHttpObj.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xmlHttpObj.setRequestHeader("Content-length", postData.length);
		xmlHttpObj.setRequestHeader("Connection", "close"); 
  		 
		xmlHttpObj.onreadystatechange = function()
		{ 
			if(xmlHttpObj.readyState == 4)
			{
				if(xmlHttpObj.status == 200)
				{
					if(callback)
					{
						if(callback != '')
						{
							eval(callback + "('" + xmlHttpObj.responseText + "');");
						}
					}
					resetTimeOut();
				}
				else
				{
					alert("An error has occurred: " + xmlHttpObj.statusText);
				}
			}
		};
		//url=url+"&sid="+Math.random();
		//xmlHttp.open("POST",url,false);
		xmlHttpObj.send(postData);
	}
	
	// Following code is written for adding support for firefox.

	var IE = document.all?true:false;
	 
	if(window.Event && document.captureEvents)
	{
		document.captureEvents(Event.CLICK);
		document.onclick = getMousePos;
	}

	// Finding the position of mouse on mouse click in firefox
	function getMousePos(e)
	{
		// grab the x-y pos.s if browser is NS 
		posx = e.pageX; 
		posy = e.pageY; 
	}
	
	// This method is used for positioning divs close to  mouse position.
	
	function positioningDivRelativeToMouse(e,id,relPosX,relPosY) 
	{
		if (IE)
		{
			if (!e) e = window.event;
			if (e.pageX || e.pageY) {
				posx = e.pageX;
				posy = e.pageY;
			}
			else if (e.clientX || e.clientY) 	{
				posx = e.clientX + document.body.scrollLeft
					+ document.documentElement.scrollLeft;
				posy = e.clientY + document.body.scrollTop
					+ document.documentElement.scrollTop;
			}
		}	
		// positioning div on the desired position.
		document.getElementById(id).style.top = posy + relPosY + 'px';
		document.getElementById(id).style.left = posx  + relPosX  + 'px';
	}
	
	function resetTimeOut()
	{
		if(document.getElementById('sessionTimeOutId') && document.getElementById('timeOutDifference'))
		{
			var timeOutId = document.getElementById('sessionTimeOutId').value;
			clearTimeout(timeOutId);
			if(document.getElementById('timeOutDifference').value == "")
			{
				timeOutId = setTimeout("warnSessionExpiration()", 29*60*1000);
			}
			else
			{
				timeOutId = setTimeout("warnSessionExpiration()", document.getElementById('timeOutDifference').value);
			}
			document.getElementById('sessionTimeOutId').value = timeOutId;
		}
	}
	