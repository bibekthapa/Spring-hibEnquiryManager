<%@include file="../../header.jsp" %>

<h1>Send Message</h1>
<form method="post" action="${SITE_URL}/dashboard/send">
<div>
    <label>From</label>
    <input type="email" class="form-control" value="${msgFrom.value}" name="name"  /> 
    <input type="hidden" name="host" value="${msgHost.value}"/>
</div>
   
    <br/>
<div>
    <label>TO</label>
    <input type="email" class="form-control" name="enquiryEmail" value="${enquiry.enquiryEmail}"/>
</div>
    <br/>
    
    <div>
    <label>Subject</label>
    <input type="text" class="form-control" name="subject" value="" required="required"/>
</div>
    <br/>

<div>
    <label>Message</label>
    <textarea class="form-control" rows="5" name="message" required="required"></textarea>
    
</div>
    <br/>
    <div>
        <button class="btn btn-primary">SEND  <span class="glyphicon glyphicon-send" onclick="return confirm('Message sent succesfully')"></span></button> 
</div>   
</form>




<%@include file="../../footer.jsp" %>