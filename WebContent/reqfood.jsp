<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">


    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="Food/css/style.css">
</head>
<body>

    <div class="main">

        <div class="container">
            <div class="booking-content">
                <div class="booking-image">
                    <img class="booking-img" src="Food/images/form-img.jpg" alt="Booking Image">
                </div>
                <div class="booking-form">
                    <form id="booking-form" action="insertuserres" method="post">
                        <h2>Book  your Food!</h2>
                        <div class="form-group form-input">
                            <input value="${user}"  type="text" name="user" required/>
                            <label   class="form-label">Username</label>
                        </div>
                       
                        <div class="form-group">
                            <div >
                                <select name="juice"  required>
                                    <option value="">Juice Items</option>
                                    <option value="Banana Juice">Banana Juice</option>
                                    <option value="Orange Juice">Orange Juice</option>
                                     <option value="PineApple Juice">PineApple Juice</option>
                                    <option value="Apple Juice">Apple Juice</option>
                                  
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="select-list">
                                <select name="main"  required>
                                    <option value="">Main Food</option>
                                    <option value="seasonalfish">Seasonal steamed fish</option>
                                    <option value="assortedmushrooms">Assorted mushrooms</option>
                                </select>
                            </div>
                        </div>
                     <div class="form-group">
                            <div class="select-list">
                                <select name="dessert"  required>
                                    <option value="">Dessert</option>
                                    <option value="seasonalfish">Seasonal steamed fish</option>
                                    <option value="assortedmushrooms">Assorted mushrooms</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-submit">
                            <input type="submit" value="Book now" class="submit"  />
                        
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </div>

    <!-- JS -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/main.js"></script>
</body>
</html>