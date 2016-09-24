angular.module("ChocolateMakerApp",[])
    .controller("ChocolateController", function($scope,$http,$timeout){
        $scope.finishedChocolate;
        console.log("Testing....");

        $scope.makeArray = function(arraySize) {
            var returnArray = [];
            for (var i = 0; i < arraySize; i++) {
                returnArray.push(i);
            }
            return returnArray;
        };

        $scope.solveChocolate = function(numSmalls, numBigs, goal){
            console.log("About to make chocolate");

            $http.get("http://localhost:8080/chocolate.json?numSmall=" + numSmalls + "&numBig=" + numBigs + "&goal=" + goal)
                .then(
                    function success(response){
                        if(hasSolution == true){
                            console.log(response.data);
                            console.log("Adding data to scope");
                            $scope.finishedChocolate = response.data;
                            console.log($scope.finishedChocolate);
                        } else if (hasSolution != true){
                            console.log("Unable to make Chocolate");
                        }
                    },
                    function error(response){
                            console.log("Unable to get data");
                    });
        };

    });


