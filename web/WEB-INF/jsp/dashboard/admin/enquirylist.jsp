<%@include  file="../../header.jsp" %>


<table class="table table-hover  table-striped">
    <tr>
    <div id="result"></div>
        <th> <input type="checkbox" onclick="toggle(this)"/></th>

        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Contact No</th> 
        <th>Course Name</th>
        <th>Enquiry Status</th>
        <th>Added Date</th>
        <th>Message</th> 
        <th>Action</th>
        <th></th>
        <th></th>

    </tr>

    <c:forEach var="enquiry" items="${enquiries}">


        <tr id="box" class="${enquiry.enquirystatus.enquirystatusColor}">
            <td> <input type="checkbox" name="foo"></td>

            <td>${enquiry.enquiryId}</td>
            <td>${enquiry.enquiryfirstName} ${enquiry.enquirylastName}</td>
            <td>${enquiry.enquiryEmail}</td>
            <td>${enquiry.enquirycontactNo}</td>
            <td>${enquiry.course.courseName}</td>
            <td>${enquiry.enquirystatus.enquirystatusType}</td>
            <td> ${enquiry.enquiryaddedDate}</td>
            <td>${enquiry.enquiryMessage}</td>
            <td>
                <a href="${SITE_URL}/dashboard/admin/edit/${enquiry.enquiryId}" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a>
            </td>
            <td> <a href="${SITE_URL}/dashboard/admin/delete/${enquiry.enquiryId}" class="btn btn-danger"><span class="glyphicon glyphicon-trash" onclick="return confirm('Are you sure?')"></span></a></td>

            <td> <a href="${SITE_URL}/dashboard/sendmail/${enquiry.enquiryId}" class="btn btn-success"><span class="glyphicon glyphicon-envelope" ></span></a></td>


        </tr> 



    </c:forEach>



</table>

<script>
    function toggle(source)
    {
        checkboxes = document.getElementsByName('foo');
        for (var i = 0; i < checkboxes.length; i++)
        {
            checkboxes[i].checked = source.checked;
        }}
    

</script> 


<%@include file="../../footer.jsp" %>