<%@include file="../header.jsp" %>


    <h1> PLEASE FILL THE ENQUIRY</h1>
    <form  action="${SITE_URL}/dashboard/save" method="post">
        <div>
            <label>FirstName</label>
            <input type="text" name="enquiryfirstName" class="form-control"/>
            
        </div>
         <br/>
        
         <div >
            <label>LastName</label>
            <input type="text" name="enquirylastName" class="form-control"/>
            
        </div>
         <br/>
         <div>
            <label>Email</label>
            <input type="email" name="enquiryEmail" class="form-control" required="required"/>
            
        </div>
         <br/>
         <div >
            <label>ContactNo</label>
            <input type="text" name="enquirycontactNo" class="form-control"/>
            
        </div>
        <br/>
        <div class="form-group">
            <label>Courses</label>
            <select class="form-control" name="course.courseId">
                
                <c:forEach var="course" items="${courses}">
                    
                <option  value="${course.courseId}">${course.courseName}</option>
               
                </c:forEach>
                  
            </select>
        </div>
        <input type="hidden" name="enquirystatus.enquirystatusId" value="1"/>
        
        
        
       
         <br/>
        
        <div class="form-group">
            <label> Message</label>
            <textarea class="form-control" name="enquiryMessage" rows="3"></textarea>
        </div>
        
         <button class="btn btn-success" type="submit">Send</button>
        
    </form>

<%@include file="../footer.jsp" %>