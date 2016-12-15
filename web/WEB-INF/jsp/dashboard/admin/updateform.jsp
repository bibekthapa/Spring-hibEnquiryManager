<%@include file="../../header.jsp" %>

<h1>Update the enquiry</h1>

<form method="post" action="${SITE_URL}/dashboard/admin/save">
    <div class="form-group">
       <div>
            <label>FirstName</label>
            <input type="text" name="enquiryfirstName" class="form-control" value="${enquiry.enquiryfirstName}"/>
            
        </div>
         <br/>
        
         <div >
            <label>LastName</label>
            <input type="text" name="enquirylastName" class="form-control" value="${enquiry.enquirylastName}"/>
            
        </div>
         <br/>
         <div>
            <label>Email</label>
            <input type="email" name="enquiryEmail" class="form-control" required="required" value="${enquiry.enquiryEmail}"/>
            
        </div>
         <br/>
         <div >
            <label>ContactNo</label>
            <input type="text" name="enquirycontactNo" class="form-control" value="${enquiry.enquirycontactNo}"/>
            
        </div>
        <br/>
        <div class="form-group">
            <label>Courses</label>
            <select class="form-control" name="course.courseId">
                <option value="${enquiry.course.courseId}" name="enquiry.course.courseId">${enquiry.course.courseName}</option>
            </select>
        </div>
        
        <div class="form-group">
            <label>EnquiryStatus</label>
            <select class="form-control" name="enquirystatus.enquirystatusId">
                <c:forEach var="enquirystat" items="${enquirystatus}">
                    <option value="${enquirystat.enquirystatusId}">${enquirystat.enquirystatusType}</option>
                    
                </c:forEach>
                
            </select>
        
       
         <br/>
        
        <div class="form-group">
            <label> Message</label>
            <textarea class="form-control" name="enquiryMessage" rows="3" placeholder="${enquiry.enquiryMessage}"/>${enquiry.enquiryMessage}</textarea>
        </div>
        
         <button class="btn btn-success" type="submit">Send</button>
        
    
    
    
    
    
    
    
    
</form>




<%@include file="../../footer.jsp" %>
