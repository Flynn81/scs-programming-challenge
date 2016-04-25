<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
<!--jquery-->
<script   src="https://code.jquery.com/jquery-1.12.2.js"   integrity="sha256-VUCyr0ZXB5VhBibo2DkTVhdspjmxUgxDGaLQx7qb7xY="   crossorigin="anonymous"></script>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<!-- Bootstrap theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
<!-- Bootstrap JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.11/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.11/js/jquery.dataTables.js"></script>
<script>
	$(document).ready(function() {

				   $('#commits').DataTable({
				   "processing": true,
        			"ajax":{
        			"contentType": "application/json",
        			"url":"listAPI/"},
        			"columns": [
                    { "data": "user" },
                    { "data": "commit" },
                    { "data": "message" }
                ],
                	"aaSorting": []
        			});
    });

</script>
</head>
<body>
    

  
	
	<div class="container">
	<div class="row">
	<div class="col-lg-12">
	<center> <h1>${message}</h1></center>
	<table id="commits" class="display">
	<thead>
            <tr>
                <th>Person's Name</th>
                <th>Commit</th>
                <th>Commit Message</th>
            </tr>
      </thead>
      <tfoot>
       <tr>
                 <th>Person's Name</th>
                <th>Commit</th>
                <th>Commit Message</th>
            </tr>
      </tfoot>
	</table>
	</div>
  </div>
  </div>
</body>

</html>