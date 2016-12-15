<%@include  file="../header.jsp" %>


<table class="table table-responsive">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Contact No</th> 
        <th>Course Name</th>
        <th>Enquiry Status</th>
        <th>Added Date</th>
        <th>Message</th>     

    </tr>

    <c:forEach var="enquiry" items="${enquiries}">
        
        <tr id="box" class="${enquiry.enquirystatus.enquirystatusColor}" >
            
            <td>${enquiry.enquiryId}</td>
            <td>${enquiry.enquiryfirstName} ${enquiry.enquirylastName}</td>
            <td>${enquiry.enquiryEmail}</td>
            <td>${enquiry.enquirycontactNo}</td>
            <td>${enquiry.course.courseName}</td>
            <td>${enquiry.enquirystatus.enquirystatusType}</td>
            <td> ${enquiry.enquiryaddedDate}</td>
            <td>${enquiry.enquiryMessage}</td>
           
        </tr> 
        
        

    </c:forEach>

</table>

<%@include file="../footer.jsp" %>