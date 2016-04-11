   $(document).ready(function() {

              $('#commitTable').dataTable({
                  "ajax": {
                        "url": "http://localhost:8080/list",
                        "dataSrc": ""
                    },
                    "columns": [
                        { "data": "personName" },
                        { "data": "commit" },
                        { "data": "commitMessage" }
                    ]
        });   
    });